package EscolaAplication.service;


import EscolaAplication.domain.Aluno;
import EscolaAplication.domain.Disciplinas;
import EscolaAplication.domain.Matricula;
import EscolaAplication.dto.MatriculaDTO;
import EscolaAplication.repository.AlunoRepository;
import EscolaAplication.repository.DisciplinaRepository;
import EscolaAplication.repository.MatriculaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatriculaService {

    private final MatriculaRepository matriculaRepository;
    private final AlunoRepository alunoRepository;
    private final DisciplinaRepository disciplinaRepository;

    public MatriculaService(MatriculaRepository matriculaRepository, AlunoRepository alunoRepository, DisciplinaRepository disciplinaRepository){
        this.matriculaRepository = matriculaRepository;
        this.alunoRepository = alunoRepository;
        this.disciplinaRepository = disciplinaRepository;
    }

    public Matricula salvar(MatriculaDTO matriculaDTO){

        Optional<Aluno> aluno = alunoRepository.findByMatricula(matriculaDTO.getAlunoMatricula());
        Optional<Disciplinas> disciplina = disciplinaRepository.findById(matriculaDTO.getDisciplinaId());

        if(aluno.isEmpty()){
            throw new IllegalArgumentException("Aluno não encontrado.");
        }

        if(disciplina.isEmpty()){
            throw new IllegalArgumentException("Disciplina não encontrada.");
        }

        Aluno alunoEncontrado = aluno.get();
        Disciplinas disciplinaEncontrada = disciplina.get();

        Matricula matricula = new Matricula(alunoEncontrado, disciplinaEncontrada);

        return matriculaRepository.save(matricula);

    }

    public List<Matricula> listar(){
        return matriculaRepository.findAll();
    }

    public Optional<Matricula> buscarPorId(int id){
        return matriculaRepository.findById(id);
    }

    public Matricula atualizar(int id, MatriculaDTO matriculaDTO){

        Optional<Matricula> matriculaEncontrada = matriculaRepository.findById(id);

        if(matriculaEncontrada.isEmpty()){
            throw new IllegalArgumentException("Matricula não encontrada.");
        }

        Matricula matricula = matriculaEncontrada.get();

        Optional<Aluno> alunoEncontrado = alunoRepository.findByMatricula(matriculaDTO.getAlunoMatricula());
        Optional<Disciplinas> disciplinaEncontrada = disciplinaRepository.findById(matriculaDTO.getDisciplinaId());

        if(alunoEncontrado.isEmpty()){
            throw new IllegalArgumentException("Aluno não encontrado.");
        }

        if(disciplinaEncontrada.isEmpty()){
            throw new IllegalArgumentException("Disciplina não encontrada.");
        }

        Aluno aluno = alunoEncontrado.get();
        Disciplinas disciplina = disciplinaEncontrada.get();

        matricula.setAluno(aluno);
        matricula.setDisciplinas(disciplina);

        return matriculaRepository.save(matricula);

    }

    public void excluir(int id){
        matriculaRepository.deleteById(id);
    }

}

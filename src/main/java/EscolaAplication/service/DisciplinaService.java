package EscolaAplication.service;

import EscolaAplication.domain.Professor;
import EscolaAplication.dto.DisciplinasDTO;
import EscolaAplication.repository.ProfessorRepository;
import EscolaAplication.domain.Disciplinas;
import EscolaAplication.repository.DisciplinaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DisciplinaService {

    private final ProfessorRepository professorRepository;
    private final DisciplinaRepository disciplinaRepository;


    public DisciplinaService(DisciplinaRepository disciplinaRepository, ProfessorRepository professorRepository){
        this.disciplinaRepository = disciplinaRepository;
        this.professorRepository = professorRepository;
    }

    public Disciplinas salvar(DisciplinasDTO disciplinasDTO){

        Optional<Professor> professor = professorRepository.findByMatricula(disciplinasDTO.getProfessorMatricula());

        if(professor.isEmpty()){
            throw new IllegalArgumentException("Professor não encontrado.");
        }

        Professor professorEncontrado = professor.get();

        Disciplinas disciplina = new Disciplinas(disciplinasDTO.getName(), disciplinasDTO.getCargaH(), professorEncontrado);

        return disciplinaRepository.save(disciplina);

    }

    public List<Disciplinas> listar(){
        return disciplinaRepository.findAll();
    }

    public Optional<Disciplinas> buscarPorId(int id){
        return disciplinaRepository.findById(id);
    }

    public Disciplinas atualizar(int id,DisciplinasDTO disciplinasDTO){

        Optional<Disciplinas> disciplinaExistente = disciplinaRepository.findById(id);

        if (disciplinaExistente.isEmpty()) {
            throw new IllegalArgumentException("Disciplina não encontrada.");
        }

        Disciplinas disciplina = disciplinaExistente.get();

        disciplina.setName(disciplinasDTO.getName());
        disciplina.setCargaH(disciplinasDTO.getCargaH());

        Optional<Professor> professor = professorRepository.findByMatricula(disciplinasDTO.getProfessorMatricula());

        if (professor.isEmpty()) {
            throw new IllegalArgumentException("Professor não encontrado.");
        }

        Professor professorEncontrado = professor.get();

        disciplina.setProfessor(professorEncontrado);

        return disciplinaRepository.save(disciplina);
    }


    public void excluir(int id){
        disciplinaRepository.deleteById(id);
    }

}

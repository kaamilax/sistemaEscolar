package EscolaAplication.service;

import org.springframework.stereotype.Service;
import EscolaAplication.domain.Aluno;
import EscolaAplication.repository.AlunoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository){
        this.alunoRepository = alunoRepository;

    }

    public Aluno salvar(Aluno aluno){
       return alunoRepository.save(aluno);

    }

    public List<Aluno> listar(){
        return alunoRepository.findAll();

    }

    public Optional<Aluno> buscarPorId(int id){
        return alunoRepository.findById(id);
    }

    public Aluno atualizar(Aluno aluno){
        return alunoRepository.save(aluno);
    }

    public void excluir(int id){
        alunoRepository.deleteById(id);
    }


}
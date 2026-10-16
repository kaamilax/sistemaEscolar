package EscolaAplication.service;


import EscolaAplication.domain.Professor;
import EscolaAplication.repository.ProfessorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {

    private final ProfessorRepository professorRepository;

    public ProfessorService(ProfessorRepository professorRepository){
        this.professorRepository = professorRepository;
    }

    public Professor salvar(Professor professor){
        return professorRepository.save(professor);
    }

    public List<Professor> listar(){
        return professorRepository.findAll();
    }

    public Optional<Professor> buscarPorId(int id){
        return professorRepository.findById(id);
    }

    public Professor atualizar(Professor professor){
        return professorRepository.save(professor);
    }

    public void excluir(int id){
        professorRepository.deleteById(id);
    }

}

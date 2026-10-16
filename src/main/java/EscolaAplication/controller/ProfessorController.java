package EscolaAplication.controller;

import EscolaAplication.domain.Professor;
import EscolaAplication.service.ProfessorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/professores")
@CrossOrigin(origins = "http://localhost:5173")
public class ProfessorController {

    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService){
        this.professorService = professorService;
    }

    @PostMapping()
    public Professor salvar(@RequestBody Professor professor){
        System.out.println(">>> ID: " + professor.getId());

        return professorService.salvar(professor);

    }

    @GetMapping()
    public List<Professor> listar(){
        return professorService.listar();
    }

    @GetMapping("{id}")
    public ResponseEntity<Professor> buscarPorId(@PathVariable int id){

        Optional<Professor> professor = professorService.buscarPorId(id);

        if(professor.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(professor.get());

    }

    @PutMapping("{id}")
    public ResponseEntity<Professor> atualizar(@PathVariable int id, @RequestBody Professor professor){

        Optional<Professor> professorExistente = professorService.buscarPorId(id);

        if(professorExistente.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        professor.setId(id);

        return ResponseEntity.ok(professorService.atualizar(professor));

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> excluir(@PathVariable int id){

        Optional<Professor> professorExistente = professorService.buscarPorId(id);

        if(professorExistente.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        professorService.excluir(id);

        return ResponseEntity.noContent().build();
    }

}

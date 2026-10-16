package EscolaAplication.controller;

import EscolaAplication.domain.Aluno;
import EscolaAplication.service.AlunoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alunos")
@CrossOrigin(origins = "http://localhost:5173")
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService){
        this.alunoService = alunoService;
    }

    @GetMapping
    public List<Aluno> listar(){
        return alunoService.listar();
    }

    @PostMapping
    public Aluno salvar(@RequestBody Aluno aluno){
        System.out.println(">>> ID: " + aluno.getId());
        return alunoService.salvar(aluno);
    }

    @GetMapping("{id}")
    public ResponseEntity<Aluno> buscarPorId(@PathVariable int id){

        Optional<Aluno> aluno = alunoService.buscarPorId(id);

        if(aluno.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(aluno.get());

    }

    @PutMapping("{id}")
    public ResponseEntity<Aluno> atualizar(@PathVariable int id, @RequestBody Aluno aluno){

        Optional<Aluno> alunoExistente = alunoService.buscarPorId(id);

        if(alunoExistente.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        aluno.setId(id);

        return ResponseEntity.ok(alunoService.atualizar(aluno));

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> excluir(@PathVariable int id){

        Optional<Aluno> alunoExistente = alunoService.buscarPorId(id);

        if(alunoExistente.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        alunoService.excluir(id);

        return ResponseEntity.noContent().build();

    }

}
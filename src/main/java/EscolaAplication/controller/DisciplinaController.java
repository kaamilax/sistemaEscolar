package EscolaAplication.controller;

import EscolaAplication.domain.Disciplinas;
import EscolaAplication.dto.DisciplinasDTO;
import EscolaAplication.service.DisciplinaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/disciplinas")
@CrossOrigin(origins = "http://localhost:5173")
public class DisciplinaController {

    private final DisciplinaService disciplinaService;

    public DisciplinaController(DisciplinaService disciplinaService){
        this.disciplinaService = disciplinaService;
    }

    @PostMapping()
    public Disciplinas salvar(@RequestBody DisciplinasDTO disciplinasDTO){
        return disciplinaService.salvar(disciplinasDTO);
    }

    @GetMapping()
    public List<Disciplinas> listar(){
        return disciplinaService.listar();
    }

    @GetMapping("{id}")
    public ResponseEntity<Disciplinas> buscarPorId(@PathVariable int id){

        Optional<Disciplinas> disciplina = disciplinaService.buscarPorId(id);

        if(disciplina.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(disciplina.get());

    }

    @PutMapping("{id}")
    public ResponseEntity<Disciplinas> atualizar(@PathVariable int id, @RequestBody DisciplinasDTO disciplinasDTO){

        Optional<Disciplinas> disciplinaExistente = disciplinaService.buscarPorId(id);

        if(disciplinaExistente.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(disciplinaService.atualizar(id, disciplinasDTO));

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> excluir(@PathVariable int id){

        Optional<Disciplinas> disciplinaExistente = disciplinaService.buscarPorId(id);

        if(disciplinaExistente.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        disciplinaService.excluir(id);

        return ResponseEntity.noContent().build();
    }






}

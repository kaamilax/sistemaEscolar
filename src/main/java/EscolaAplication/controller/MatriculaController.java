package EscolaAplication.controller;


import EscolaAplication.domain.Matricula;
import EscolaAplication.dto.MatriculaDTO;
import EscolaAplication.service.MatriculaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class MatriculaController {

    private final MatriculaService matriculaService;

    public MatriculaController(MatriculaService matriculaService){
        this.matriculaService = matriculaService;
    }

    @PostMapping("/matriculas")
    public Matricula salvar(@RequestBody MatriculaDTO matriculaDTO){
        return matriculaService.salvar(matriculaDTO);
    }

    @GetMapping("/matriculas")
    public List<Matricula> listar(){
        return matriculaService.listar();
    }

    @GetMapping("/matriculas/{id}")
    public ResponseEntity<Matricula> buscarPorId(@PathVariable int id){
        Optional<Matricula> matricula = matriculaService.buscarPorId(id);

        if(matricula.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(matricula.get());

    }

    @PutMapping("/matriculas/{id}")
    public ResponseEntity<Matricula> atualizar(@PathVariable int id, @RequestBody MatriculaDTO matriculaDTO){

        Optional<Matricula> matriculaExistente = matriculaService.buscarPorId(id);

        if(matriculaExistente.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(matriculaService.atualizar(id, matriculaDTO));

    }

    @DeleteMapping("/matriculas/{id}")
    public ResponseEntity<Void> excluir(@PathVariable int id){
        Optional<Matricula> matriculaEncontrada = matriculaService.buscarPorId(id);

        if(matriculaEncontrada.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        matriculaService.excluir(id);

        return ResponseEntity.noContent().build();

    }

}

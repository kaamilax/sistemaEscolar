package EscolaAplication.controller;

import EscolaAplication.domain.Nota;
import EscolaAplication.dto.NotaDTO;
import EscolaAplication.service.NotaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class NotaController {

    private final NotaService notaService;

    public NotaController(NotaService notaService){
        this.notaService = notaService;
    }

    @PostMapping("/notas")
    public Nota salvar(@RequestBody NotaDTO notaDTO){
        return notaService.salvar(notaDTO);
    }

    @GetMapping("/notas")
    public List<Nota> listar(){
        return notaService.listar();
    }

    @GetMapping("/notas/{id}")
    public ResponseEntity<Nota> buscarPorId(@PathVariable int id){
        Optional<Nota> nota = notaService.buscarPorId(id);

        if(nota.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(nota.get());

    }

    @PutMapping("/notas/{id}")
    public ResponseEntity<Nota> atualizar(@PathVariable int id, @RequestBody NotaDTO notaDTO){

        Optional<Nota> notaEncontrada = notaService.buscarPorId(id);

        if(notaEncontrada.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(notaService.atualizar(id, notaDTO));

    }

    @DeleteMapping("/notas/{id}")
    public ResponseEntity<Void> excluir(@PathVariable int id){

        Optional<Nota> notaEncontrada = notaService.buscarPorId(id);

        if(notaEncontrada.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        notaService.excluir(id);

        return ResponseEntity.noContent().build();

    }

}

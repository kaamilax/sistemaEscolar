package EscolaAplication.service;


import EscolaAplication.domain.Matricula;
import EscolaAplication.domain.Nota;
import EscolaAplication.dto.NotaDTO;
import EscolaAplication.repository.MatriculaRepository;
import EscolaAplication.repository.NotaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotaService {

    private final NotaRepository notaRepository;
    private final MatriculaRepository matriculaRepository;

    public NotaService(NotaRepository notaRepository, MatriculaRepository matriculaRepository){
        this.notaRepository = notaRepository;
        this.matriculaRepository = matriculaRepository;
    }

    public Nota salvar(NotaDTO notaDTO){

        if (!notaDTO.getAvaliacao().equals("N1") && !notaDTO.getAvaliacao().equals("N2")) {
            throw new IllegalArgumentException("A avaliação deve ser N1 ou N2.");
        }

        Optional<Matricula> matriculaEncontrada = matriculaRepository.findById(notaDTO.getMatriculaId());

        if(matriculaEncontrada.isEmpty()){
            throw new IllegalArgumentException("Matricula não encontrada.");
        }

        Matricula matricula = matriculaEncontrada.get();

        long quantidadeNotas = notaRepository.countByMatriculaId(notaDTO.getMatriculaId());

        if (quantidadeNotas >= 2) {
            throw new IllegalArgumentException("A matrícula já possui duas notas.");
        }

        if (notaRepository.existsByMatriculaIdAndAvaliacao(
                notaDTO.getMatriculaId(),
                notaDTO.getAvaliacao()
        )) {
            throw new IllegalArgumentException("Essa avaliação já existe para a matrícula.");
        }

        Nota nota = new Nota(
                notaDTO.getValor(),
                notaDTO.getAvaliacao(),
                matricula
        );

        return notaRepository.save(nota);

    }

    public List<Nota> listar(){
        return notaRepository.findAll();
    }

    public Optional<Nota> buscarPorId(int id){
        return notaRepository.findById(id);
    }

    public Nota atualizar(int id, NotaDTO notaDTO){

        if (!notaDTO.getAvaliacao().equals("N1") && !notaDTO.getAvaliacao().equals("N2")) {
            throw new IllegalArgumentException("A avaliação deve ser N1 ou N2.");
        }

        Optional<Nota> notaEncontrada = notaRepository.findById(id);

        if(notaEncontrada.isEmpty()){
            throw new IllegalArgumentException("Nota não encontrada.");
        }

        Nota nota = notaEncontrada.get();

        Optional<Matricula> matriculaEncontrada = matriculaRepository.findById(notaDTO.getMatriculaId());




        if(matriculaEncontrada.isEmpty()){
            throw new IllegalArgumentException("Matricula não encontrada.");
        }

        Matricula matricula = matriculaEncontrada.get();

        if (notaRepository.existsByMatriculaIdAndAvaliacaoAndIdNot(
                notaDTO.getMatriculaId(),
                notaDTO.getAvaliacao(),
                id
        )) {
            throw new IllegalArgumentException("Essa avaliação já existe para a matrícula.");
        }


        nota.setValor(notaDTO.getValor());
        nota.setMatricula(matricula);
        nota.setAvaliacao(notaDTO.getAvaliacao());

        return notaRepository.save(nota);

    }

    public void excluir(int id){
        notaRepository.deleteById(id);
    }

}

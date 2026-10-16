package EscolaAplication.repository;

import EscolaAplication.domain.Nota;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotaRepository extends JpaRepository<Nota, Integer> {
    long countByMatriculaId(int matriculaId);
    boolean existsByMatriculaIdAndAvaliacao(int matriculaId, String avaliacao);
    boolean existsByMatriculaIdAndAvaliacaoAndIdNot(
            int matriculaId,
            String avaliacao,
            int id
    );
}

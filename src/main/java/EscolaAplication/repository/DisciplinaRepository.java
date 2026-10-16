package EscolaAplication.repository;

import EscolaAplication.domain.Disciplinas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisciplinaRepository extends JpaRepository<Disciplinas, Integer> {
}

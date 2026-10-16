package EscolaAplication.repository;

import EscolaAplication.domain.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfessorRepository extends JpaRepository<Professor,Integer> {

    Optional<Professor> findByMatricula(String matricula);

}

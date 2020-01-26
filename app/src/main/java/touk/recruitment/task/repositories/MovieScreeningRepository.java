package touk.recruitment.task.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import touk.recruitment.task.repositories.entities.movie.MovieEntity;

public interface MovieScreeningRepository extends JpaRepository<MovieEntity, Long> {

}

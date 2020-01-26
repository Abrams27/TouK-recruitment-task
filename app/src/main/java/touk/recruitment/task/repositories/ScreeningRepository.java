package touk.recruitment.task.repositories;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import touk.recruitment.task.repositories.entities.ScreeningEntity;

public interface ScreeningRepository extends JpaRepository<ScreeningEntity, Long> {

  List<ScreeningEntity> findDistinctAllByTimeBetween(LocalDateTime start, LocalDateTime end);

}

package touk.recruitment.task.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import touk.recruitment.task.repositories.entities.ScreeningEntity;
import touk.recruitment.task.repositories.entities.reservation.ReservationEntity;

public interface ReservationRepository extends JpaRepository<ReservationEntity, Long> {

  List<ReservationEntity> findAllByScreening(ScreeningEntity screening);
}

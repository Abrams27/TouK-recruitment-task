package touk.recruitment.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import touk.recruitment.task.repository.entities.movie.MovieEntity;
import touk.recruitment.task.repository.entities.reservation.ScreeningEntity;
import touk.recruitment.task.repository.entities.room.ScreeningRoomEntity;

public interface TickeetTypeRepository extends JpaRepository<ScreeningEntity, Long> {

}

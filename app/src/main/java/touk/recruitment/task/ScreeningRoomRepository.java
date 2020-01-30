package touk.recruitment.task;

import org.springframework.data.jpa.repository.JpaRepository;
import touk.recruitment.task.repositories.entities.room.ScreeningRoomEntity;

public interface ScreeningRoomRepository extends JpaRepository<ScreeningRoomEntity, Long> {

}

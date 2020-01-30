package touk.recruitment.task.usecase;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import touk.recruitment.task.mappers.dto.ScreeningRoomDtoMapper;
import touk.recruitment.task.models.ScreeningRoomDto;
import touk.recruitment.task.repositories.entities.room.SeatEntity;
import touk.recruitment.task.services.ScreeningAvailableSeatsService;

@Component
@AllArgsConstructor
public class GetScreeningDetails {

  private ScreeningAvailableSeatsService screeningAvailableSeatsService;

  public ScreeningRoomDto execute(Long id) {
    Long screeningRoomId = screeningAvailableSeatsService.getScreeningRoomIdOfScreening(id);
    List<SeatEntity> availableSeats = screeningAvailableSeatsService.getAvailableSeatsOnScreening(id);

    return ScreeningRoomDtoMapper.map(screeningRoomId, availableSeats);
  }

}

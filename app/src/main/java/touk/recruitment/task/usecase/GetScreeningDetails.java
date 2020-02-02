package touk.recruitment.task.usecase;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import touk.recruitment.task.mappers.dto.ScreeningRoomDtoMapper;
import touk.recruitment.task.models.ScreeningRoomDto;
import touk.recruitment.task.repositories.entities.room.SeatEntity;
import touk.recruitment.task.services.ScreeningAvailableSeatsService;
import touk.recruitment.task.services.ScreeningService;

@Component
@AllArgsConstructor
public class GetScreeningDetails {

  private ScreeningAvailableSeatsService screeningAvailableSeatsService;
  private ScreeningService screeningService;

  public ScreeningRoomDto execute(Long id) {
    Long screeningRoomId = screeningService.getScreeningRoomIdOfScreening(id);
    List<SeatEntity> availableSeats = screeningAvailableSeatsService.getAvailableSeatsOnScreening(id);

    return ScreeningRoomDtoMapper.map(screeningRoomId, availableSeats);
  }

}

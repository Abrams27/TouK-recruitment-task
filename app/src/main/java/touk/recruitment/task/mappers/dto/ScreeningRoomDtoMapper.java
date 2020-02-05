package touk.recruitment.task.mappers.dto;

import java.util.List;
import java.util.stream.Collectors;
import lombok.experimental.UtilityClass;
import touk.recruitment.task.models.ScreeningRoomDto;
import touk.recruitment.task.models.SeatDto;
import touk.recruitment.task.repositories.entities.room.SeatEntity;

@UtilityClass
public class ScreeningRoomDtoMapper {

  public ScreeningRoomDto map(Long screeningRoomId, List<SeatEntity> availableSeats) {
    return ScreeningRoomDto.builder()
        .screeningRoomId(screeningRoomId)
        .availableSeats(mapSeats(availableSeats))
        .build();
  }

  private List<SeatDto> mapSeats(List<SeatEntity> seatsRows) {
    return seatsRows.stream()
        .map(SeatDtoMapper::map)
        .collect(Collectors.toList());
  }

}

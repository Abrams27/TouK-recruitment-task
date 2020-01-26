package touk.recruitment.task.mappers.dto;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.experimental.UtilityClass;
import touk.recruitment.task.models.ScreeningRoomDto;
import touk.recruitment.task.models.SeatDto;
import touk.recruitment.task.repositories.entities.room.ScreeningRoomEntity;
import touk.recruitment.task.repositories.entities.room.SeatsRowEntity;

@UtilityClass
public class ScreeningRoomDtoMapper {

  public ScreeningRoomDto map(ScreeningRoomEntity screeningRoomEntity) {
    return ScreeningRoomDto.builder()
        .screeningRoomId(screeningRoomEntity.getId())
        .availableSeats(mapSeats(screeningRoomEntity.getSeatsRows()))
        .build();
  }

  private List<SeatDto> mapSeats(Set<SeatsRowEntity> seatsRows) {
    return seatsRows.stream()
        .map(SeatsRowEntity::getSeats)
        .flatMap(Collection::stream)
        .map(SeatDtoMapper::map)
        .collect(Collectors.toList());
  }

}

package touk.recruitment.task.mappers.dto;

import lombok.experimental.UtilityClass;
import touk.recruitment.task.models.SeatDto;
import touk.recruitment.task.repositories.entities.room.SeatEntity;

@UtilityClass
public class SeatDtoMapper {

  public SeatDto map(SeatEntity seatEntity) {
    return SeatDto.builder()
        .rowNumber(seatEntity.getSeatsRow().getRowNumber())
        .numberInRow(seatEntity.getNumberInRow())
        .build();
  }

}

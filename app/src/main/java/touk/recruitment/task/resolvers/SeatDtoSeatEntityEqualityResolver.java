package touk.recruitment.task.resolvers;

import org.springframework.stereotype.Component;
import touk.recruitment.task.models.SeatDto;
import touk.recruitment.task.repositories.entities.room.SeatEntity;

@Component
public class SeatDtoSeatEntityEqualityResolver {

  public boolean areEqual(SeatEntity seatEntity, SeatDto seatDto) {
    return areEqual(seatEntity, seatDto, 0);
  }

  public boolean areEqual(SeatEntity seatEntity, SeatDto seatDto, Integer seatsInRowShift) {
    return areSeatEntityAndSeatDtoNumberInRowEqual(seatEntity, seatDto, seatsInRowShift)
        && areSeatEntityAndSeatDtoRowsEqual(seatEntity, seatDto);
  }

  private boolean areSeatEntityAndSeatDtoNumberInRowEqual(SeatEntity seatEntity, SeatDto seatDto, Integer shift) {
    return seatEntity
        .getNumberInRow()
        .equals(seatDto.getNumberInRow() + shift);
  }

  private boolean areSeatEntityAndSeatDtoRowsEqual(SeatEntity seatEntity, SeatDto seatDto) {
    return seatEntity
        .getSeatsRow()
        .getRowNumber()
        .equals(seatDto.getRowNumber());
  }
}

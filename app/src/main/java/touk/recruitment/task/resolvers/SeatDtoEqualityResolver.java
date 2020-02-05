package touk.recruitment.task.resolvers;

import org.springframework.stereotype.Component;
import touk.recruitment.task.models.SeatDto;

@Component
public class SeatDtoEqualityResolver {

  public boolean areEqual(SeatDto seatDto1, SeatDto seatDto2, Integer shift) {
    return areRowNumberEqual(seatDto1, seatDto2)
        && areNumberInRowEqual(seatDto1, seatDto2, shift);
  }

  private boolean areRowNumberEqual(SeatDto seatDto1, SeatDto seatDto2) {
    return seatDto1
        .getRowNumber()
        .equals(seatDto2.getRowNumber());
  }

  private boolean areNumberInRowEqual(SeatDto seatDto1, SeatDto seatDto2, Integer shift) {
    return seatDto1
        .getNumberInRow()
        .equals(seatDto2.getNumberInRow() + shift);
  }

}

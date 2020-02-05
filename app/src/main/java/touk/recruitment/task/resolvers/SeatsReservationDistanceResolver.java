package touk.recruitment.task.resolvers;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import touk.recruitment.task.models.SeatDto;
import touk.recruitment.task.repositories.entities.room.SeatEntity;

@Component
@AllArgsConstructor
public class SeatsReservationDistanceResolver {

  private SeatDtoSeatEntityEqualityResolver seatDtoSeatEntityEqualityResolver;

  public boolean willAnySeatMakeGap(List<SeatDto> seats, List<SeatEntity> reservedSeats) {
    return seats.stream()
        .anyMatch(seat -> isShiftedSeatReserved(seat, reservedSeats));
  }

  private boolean isShiftedSeatReserved(SeatDto seatDto, List<SeatEntity> reservedSeats) {
    return isShiftedSeatReservedLeft(seatDto, reservedSeats)
        || isShiftedSeatReservedRight(seatDto, reservedSeats);
  }

  private boolean isShiftedSeatReservedLeft(SeatDto seatDto, List<SeatEntity> reservedSeats) {
    return isShiftedSeatReserved(seatDto, reservedSeats, -2)
        && !isShiftedSeatReserved(seatDto, reservedSeats, -1);
  }

  private boolean isShiftedSeatReservedRight(SeatDto seatDto, List<SeatEntity> reservedSeats) {
    return isShiftedSeatReserved(seatDto, reservedSeats, 2)
        && !isShiftedSeatReserved(seatDto, reservedSeats, 1);
  }

  private boolean isShiftedSeatReserved(SeatDto seatDto, List<SeatEntity> reservedSeats, Integer shift) {
    return reservedSeats.stream()
        .anyMatch(seatEntity -> seatDtoSeatEntityEqualityResolver.areEqual(seatEntity, seatDto, shift));
  }

}

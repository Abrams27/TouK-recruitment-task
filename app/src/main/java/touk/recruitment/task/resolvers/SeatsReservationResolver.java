package touk.recruitment.task.resolvers;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import touk.recruitment.task.models.SeatDto;
import touk.recruitment.task.repositories.entities.room.SeatEntity;

@Component
@AllArgsConstructor
public class SeatsReservationResolver {

  private SeatDtoSeatEntityEqualityResolver seatDtoSeatEntityEqualityResolver;

  public boolean isNotReserved(SeatEntity seatEntity, List<SeatEntity> reservedSeats) {
    return reservedSeats.stream()
        .noneMatch(reservedSeat -> reservedSeat.equals(seatEntity));
  }

  public boolean isAnyReserved(List<SeatDto> seats, List<SeatEntity> reservedSeats) {
    return seats.stream().anyMatch(seat -> isSeatDtoReserved(seat, reservedSeats));
  }

  private boolean isSeatDtoReserved(SeatDto seat, List<SeatEntity> reservedSeats) {
    return reservedSeats.stream()
        .anyMatch(seatEntity -> seatDtoSeatEntityEqualityResolver.areEqual(seatEntity, seat));
  }

}

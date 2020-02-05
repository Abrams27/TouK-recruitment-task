package touk.recruitment.task.resolvers;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import touk.recruitment.task.models.SeatDto;
import touk.recruitment.task.repositories.entities.room.SeatEntity;

@Component
@AllArgsConstructor
public class SeatsExistenceResolver {

  private SeatDtoSeatEntityEqualityResolver seatDtoSeatEntityEqualityResolver;

  public boolean isAnyNotInRoom(List<SeatDto> seats, List<SeatEntity> allSeatsInScreeningRoom) {
    return seats.stream()
        .anyMatch(seat -> isNotSeatInScreeningRoom(seat, allSeatsInScreeningRoom));
  }

  private boolean isNotSeatInScreeningRoom(SeatDto seat, List<SeatEntity> allSeatsInScreeningRoom) {
    return allSeatsInScreeningRoom.stream()
        .noneMatch(seatInScreeningRoom -> seatDtoSeatEntityEqualityResolver.areEqual(seatInScreeningRoom, seat));
  }

}

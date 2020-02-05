package touk.recruitment.task.services;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import touk.recruitment.task.exceptions.SeatsAlreadyReservedException;
import touk.recruitment.task.exceptions.WrongRowSeatsSelectionException;
import touk.recruitment.task.exceptions.WrongSeatException;
import touk.recruitment.task.models.SeatDto;
import touk.recruitment.task.repositories.ReservationRepository;
import touk.recruitment.task.repositories.entities.ScreeningEntity;
import touk.recruitment.task.repositories.entities.reservation.ReservationEntity;
import touk.recruitment.task.repositories.entities.room.SeatEntity;
import touk.recruitment.task.repositories.entities.room.SeatsRowEntity;
import touk.recruitment.task.resolvers.SeatsExistenceResolver;
import touk.recruitment.task.resolvers.SeatsReservationDistanceResolver;
import touk.recruitment.task.resolvers.SeatsReservationResolver;

@Service
@AllArgsConstructor
public class ScreeningAvailableSeatsService {

  private ScreeningService screeningService;

  private SeatsReservationDistanceResolver seatsReservationDistanceResolver;
  private SeatsReservationResolver seatsReservationResolver;
  private SeatsExistenceResolver seatsExistenceResolver;

  private ReservationRepository reservationRepository;


  public List<SeatEntity> getAvailableSeatsOnScreening(Long screeningId) {
    List<SeatEntity> reservedSeats = getReservedSeatsOnScreening(screeningId);

    return getAllSeatsInTheScreeningRoomOnScreening(screeningId).stream()
        .filter(seatEntity -> seatsReservationResolver.isNotReserved(seatEntity, reservedSeats))
        .collect(Collectors.toList());
  }

  public void validateSeatsToReservation(Long screeningId, List<SeatDto> seats) {
    List<SeatEntity> reservedSeats = getReservedSeatsOnScreening(screeningId);
    List<SeatEntity> allSeatsInScreeningRoom = getAllSeatsInTheScreeningRoomOnScreening(screeningId);

    if (seatsExistenceResolver.isAnyNotInRoom(seats, allSeatsInScreeningRoom)) {
      throw new WrongSeatException("No such seat in screening room");
    }

    if (seatsReservationResolver.isAnyReserved(seats, reservedSeats)) {
      throw new SeatsAlreadyReservedException("Seat already reserved");
    }

    if (seatsReservationDistanceResolver.willAnySeatMakeGap(seats, reservedSeats)) {
      throw new WrongRowSeatsSelectionException("Single place between reserved seats left");
    }
  }

  private List<SeatEntity> getReservedSeatsOnScreening(Long screeningId) {
    ScreeningEntity screeningEntity = screeningService.getScreeningEntity(screeningId);

    return reservationRepository
        .findAllByScreening(screeningEntity).stream()
        .map(ReservationEntity::getSeats)
        .flatMap(Collection::stream)
        .collect(Collectors.toList());
  }

  private List<SeatEntity> getAllSeatsInTheScreeningRoomOnScreening(Long screeningId) {
    return screeningService.getScreeningEntity(screeningId)
        .getRoom()
        .getSeatsRows().stream()
        .map(SeatsRowEntity::getSeats)
        .flatMap(Collection::stream)
        .collect(Collectors.toList());
  }

}

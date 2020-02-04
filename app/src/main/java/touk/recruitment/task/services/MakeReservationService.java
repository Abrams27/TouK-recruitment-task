package touk.recruitment.task.services;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import touk.recruitment.task.mappers.entity.ReservationEntityMapper;
import touk.recruitment.task.mappers.entity.UserEntityMapper;
import touk.recruitment.task.models.SeatDto;
import touk.recruitment.task.models.request.TicketsDto;
import touk.recruitment.task.models.request.UserDto;
import touk.recruitment.task.repositories.ReservationRepository;
import touk.recruitment.task.repositories.entities.ScreeningEntity;
import touk.recruitment.task.repositories.entities.reservation.ReservationEntity;
import touk.recruitment.task.repositories.entities.reservation.UserEntity;
import touk.recruitment.task.repositories.entities.room.SeatEntity;
import touk.recruitment.task.repositories.entities.ticket.TicketEntity;
import touk.recruitment.task.resolvers.SeatDtoSeatEntityEqualityResolver;

@Service
@AllArgsConstructor
public class MakeReservationService {

  private ScreeningAvailableSeatsService screeningAvailableSeatsService;
  private ReservationRepository reservationRepository;
  private SeatDtoSeatEntityEqualityResolver seatDtoSeatEntityEqualityResolver;
  private TicketService ticketService;
  private ScreeningService screeningService;

  public ReservationEntity makeReservation(Long screeningId, UserDto user, List<SeatDto> seats,
      List<TicketsDto> tickets) {
    ReservationEntity reservationEntity = buildReservationEntity(screeningId, user, seats, tickets);


    return reservationRepository.save(reservationEntity);
  }

  private ReservationEntity buildReservationEntity(Long screeningId, UserDto user, List<SeatDto> seats,
      List<TicketsDto> tickets) {
    Set<SeatEntity> reservedSeats = getReservedSeatsEntity(screeningId, seats);
    UserEntity userEntity = UserEntityMapper.map(user);
    ScreeningEntity screeningEntity = screeningService.getScreeningEntity(screeningId);
    Set<TicketEntity> ticketEntities = ticketService.ticketsDtoToTicketsEntity(tickets);

    return ReservationEntityMapper
        .map(screeningEntity, userEntity, ticketEntities, reservedSeats);
  }

  private Set<SeatEntity> getReservedSeatsEntity(Long screeningId, List<SeatDto> seats) {
    return screeningAvailableSeatsService
        .getAvailableSeatsOnScreening(screeningId).stream()
        .filter(seatEntity -> isEntityInReservedSeats(seatEntity, seats))
        .collect(Collectors.toSet());
  }

  private boolean isEntityInReservedSeats(SeatEntity seatEntity, List<SeatDto> seats) {
    return seats.stream()
        .anyMatch(seatDto -> seatDtoSeatEntityEqualityResolver.areEqual(seatEntity, seatDto));
  }


}

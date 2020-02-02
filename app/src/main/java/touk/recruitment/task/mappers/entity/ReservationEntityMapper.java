package touk.recruitment.task.mappers.entity;

import java.util.Set;
import lombok.experimental.UtilityClass;
import touk.recruitment.task.repositories.entities.ScreeningEntity;
import touk.recruitment.task.repositories.entities.reservation.ReservationEntity;
import touk.recruitment.task.repositories.entities.reservation.UserEntity;
import touk.recruitment.task.repositories.entities.room.SeatEntity;
import touk.recruitment.task.repositories.entities.ticket.TicketEntity;

@UtilityClass
public class ReservationEntityMapper {

  public ReservationEntity map(ScreeningEntity screeningEntity, UserEntity userEntity,
      Set<TicketEntity> tickets, Set<SeatEntity> seats) {
    return ReservationEntity.builder()
        .screening(screeningEntity)
        .user(userEntity)
        .tickets(tickets)
        .seats(seats)
        .build();
  }
}

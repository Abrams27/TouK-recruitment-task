package touk.recruitment.task.mappers.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import touk.recruitment.task.config.ReservationExpirationProperties;
import touk.recruitment.task.models.ReservationResponseDto;
import touk.recruitment.task.repositories.entities.ScreeningEntity;
import touk.recruitment.task.repositories.entities.reservation.ReservationEntity;
import touk.recruitment.task.repositories.entities.ticket.TicketEntity;
import touk.recruitment.task.repositories.entities.ticket.TicketTypeEntity;

@Component
@AllArgsConstructor
public class ReservationResponseDtoMapper {

  private ReservationExpirationProperties reservationExpirationProperties;

  public ReservationResponseDto map(ReservationEntity reservationEntity) {
    return ReservationResponseDto.builder()
        .totalAmountToPay(calculateTotalAmountToPay(reservationEntity.getTickets()))
        .reservationExpirationTime(calculateExpirationTime(reservationEntity.getScreening()))
        .build();
  }

  private BigDecimal calculateTotalAmountToPay(Set<TicketEntity> tickets) {
    return tickets.stream()
        .map(TicketEntity::getType)
        .map(TicketTypeEntity::getPrice)
        .reduce(BigDecimal.ZERO, BigDecimal::add);
  }

  private LocalDateTime calculateExpirationTime(ScreeningEntity screeningEntity) {
    return screeningEntity
        .getTime()
        .minusMinutes(reservationExpirationProperties.getMinutesBeforeScreening());
  }

}

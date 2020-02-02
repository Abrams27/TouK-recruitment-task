package touk.recruitment.task.mappers.entity;

import lombok.experimental.UtilityClass;
import touk.recruitment.task.repositories.entities.ticket.TicketEntity;
import touk.recruitment.task.repositories.entities.ticket.TicketTypeEntity;

@UtilityClass
public class TicketEntityMapper {

  public TicketEntity map(TicketTypeEntity type) {
    return TicketEntity.builder()
        .type(type)
        .build();
  }

}

package touk.recruitment.task.mappers.entity;

import lombok.experimental.UtilityClass;
import touk.recruitment.task.models.request.TicketTypeDto;
import touk.recruitment.task.repositories.entities.ticket.TicketTypeEnum;

@UtilityClass
public class TicketTypeEnumMapper {

  public TicketTypeEnum map(TicketTypeDto ticketTypeDto) {
    return TicketTypeEnum
        .valueOf(ticketTypeDto.toString());
  }

}

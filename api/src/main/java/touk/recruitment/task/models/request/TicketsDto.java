package touk.recruitment.task.models.request;

import lombok.Data;

@Data
public class TicketsDto {

  private Integer numberOfTickets;
  private TicketTypeDto type;

}

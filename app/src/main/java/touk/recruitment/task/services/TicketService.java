package touk.recruitment.task.services;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import touk.recruitment.task.mappers.entity.TicketEntityMapper;
import touk.recruitment.task.mappers.entity.TicketTypeEnumMapper;
import touk.recruitment.task.models.request.TicketTypeDto;
import touk.recruitment.task.models.request.TicketsDto;
import touk.recruitment.task.repositories.TicketRepository;
import touk.recruitment.task.repositories.entities.ticket.TicketEntity;
import touk.recruitment.task.repositories.entities.ticket.TicketTypeEntity;

@Service
@AllArgsConstructor
public class TicketService {

  private TicketRepository ticketRepository;

  public Set<TicketEntity> ticketsDtoToTicketsEntity(List<TicketsDto> tickets) {
    return tickets.stream()
        .map(this::ticketsDtoToEntities)
        .flatMap(Collection::stream)
        .collect(Collectors.toSet());
  }

  private List<TicketEntity> ticketsDtoToEntities(TicketsDto tickets) {
    return Stream.generate(() -> ticketDtoToEntity(tickets))
        .limit(tickets.getNumberOfTickets())
        .collect(Collectors.toList());
  }

  private TicketEntity ticketDtoToEntity(TicketsDto tickets) {
    return TicketEntityMapper
        .map(ticketTypeDtoToEntity(tickets.getType()));
  }

  private TicketTypeEntity ticketTypeDtoToEntity(TicketTypeDto ticketTypeDto) {
    return ticketRepository
        .findByName(TicketTypeEnumMapper.map(ticketTypeDto));
  }

}

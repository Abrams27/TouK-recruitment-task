package touk.recruitment.task.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import touk.recruitment.task.repositories.entities.ticket.TicketTypeEntity;
import touk.recruitment.task.repositories.entities.ticket.TicketTypeEnum;

public interface TicketRepository extends JpaRepository<TicketTypeEntity, Long> {

  TicketTypeEntity findByName(TicketTypeEnum name);
}

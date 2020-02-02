package touk.recruitment.task.models.request;

import java.util.List;
import lombok.Builder;
import lombok.Data;
import touk.recruitment.task.models.SeatDto;

@Data
@Builder
public class ReservationRequestDto {

  private Long screeningId;
  private UserDto user;
  private List<SeatDto> seats;
  private List<TicketsDto> tickets;

}

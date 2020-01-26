package touk.recruitment.task.models.request;

import java.util.List;
import lombok.Builder;
import lombok.Data;
import touk.recruitment.task.models.SeatDto;

@Data
@Builder
public class ReservationRequestDto {

  private UserDto user;
  private Long screeningRoomId;
  private List<SeatDto> seats;
}

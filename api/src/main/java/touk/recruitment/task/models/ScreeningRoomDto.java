package touk.recruitment.task.models;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ScreeningRoomDto {

  private Long screeningRoomId;
  private List<SeatDto> availableSeats;

}

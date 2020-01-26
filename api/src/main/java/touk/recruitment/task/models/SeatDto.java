package touk.recruitment.task.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SeatDto {

  private Integer rowNumber;
  private Integer numberInRow;
}

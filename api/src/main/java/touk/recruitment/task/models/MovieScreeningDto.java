package touk.recruitment.task.models;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MovieScreeningDto {

  private Long screeningId;
  private LocalDateTime screeningBeginning;
  private Integer screeningDuration;

}

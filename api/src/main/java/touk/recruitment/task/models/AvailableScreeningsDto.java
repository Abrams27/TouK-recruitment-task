package touk.recruitment.task.models;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AvailableScreeningsDto {

  private String movieTitle;
  private List<MovieScreeningDto> screenings;

}

package touk.recruitment.task.usecase;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import touk.recruitment.task.models.AvailableScreeningsDto;

@Component
@AllArgsConstructor
public class GetAvailableScreening {

  public List<AvailableScreeningsDto> execute(Date day, java.time.LocalTime intervalBegin, LocalTime intervalEnd) {
    // todo
    return null;
  }
}

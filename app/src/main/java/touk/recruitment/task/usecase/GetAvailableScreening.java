package touk.recruitment.task.usecase;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import touk.recruitment.task.mappers.dto.AvailableScreeningsDtoMapper;
import touk.recruitment.task.models.AvailableScreeningsDto;
import touk.recruitment.task.repositories.ScreeningRepository;
import touk.recruitment.task.repositories.entities.ScreeningEntity;

@Component
@AllArgsConstructor
public class GetAvailableScreening {

  private ScreeningRepository screeningRepository;

  public List<AvailableScreeningsDto> execute(LocalDate date, LocalTime intervalBeginning, LocalTime intervalEnding) {
    return screeningRepository
        .findDistinctAllByTimeBetween(LocalDateTime.of(date, intervalBeginning), LocalDateTime.of(date, intervalEnding))
        .stream()
        .map(ScreeningEntity::getMovie)
        .distinct()
        .map(AvailableScreeningsDtoMapper::map)
        .collect(Collectors.toList());
  }
}


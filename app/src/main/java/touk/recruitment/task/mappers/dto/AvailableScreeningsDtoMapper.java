package touk.recruitment.task.mappers.dto;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.experimental.UtilityClass;
import touk.recruitment.task.models.AvailableScreeningsDto;
import touk.recruitment.task.models.MovieScreeningDto;
import touk.recruitment.task.repositories.entities.ScreeningEntity;
import touk.recruitment.task.repositories.entities.movie.MovieEntity;

@UtilityClass
public class AvailableScreeningsDtoMapper {

  public AvailableScreeningsDto map(MovieEntity movieEntity) {
    return AvailableScreeningsDto.builder()
        .movieTitle(movieEntity.getTitle())
        .screenings(mapMovieScreening(movieEntity.getScreenings()))
        .movieDuration(movieEntity.getRuntime())
        .build();
  }

  private List<MovieScreeningDto> mapMovieScreening(Set<ScreeningEntity> screeningEntities) {
    return screeningEntities.stream()
        .map(MovieScreeningDtoMapper::map)
        .collect(Collectors.toList());
  }

}

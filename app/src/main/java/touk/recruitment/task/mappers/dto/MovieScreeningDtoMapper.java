package touk.recruitment.task.mappers.dto;

import lombok.experimental.UtilityClass;
import touk.recruitment.task.models.MovieScreeningDto;
import touk.recruitment.task.repositories.entities.ScreeningEntity;

@UtilityClass
public class MovieScreeningDtoMapper {

  public MovieScreeningDto map(ScreeningEntity screeningEntity) {
    return MovieScreeningDto.builder()
        .screeningId(screeningEntity.getId())
        .screeningBeginning(screeningEntity.getTime())
        .build();
  }

}

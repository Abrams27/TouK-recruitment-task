package touk.recruitment.task.usecase;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import touk.recruitment.task.mappers.dto.ScreeningRoomDtoMapper;
import touk.recruitment.task.models.ScreeningRoomDto;
import touk.recruitment.task.repositories.ScreeningRepository;
import touk.recruitment.task.repositories.entities.ScreeningEntity;

@Component
@AllArgsConstructor
public class GetScreeningDetails {

  private ScreeningRepository screeningRepository;

  public ResponseEntity<ScreeningRoomDto> execute(Long id) {
    return screeningRepository.findById(id)
        .map(ScreeningEntity::getRoom)
        .map(ScreeningRoomDtoMapper::map)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

}

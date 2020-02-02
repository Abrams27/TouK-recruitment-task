package touk.recruitment.task.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import touk.recruitment.task.exceptions.InvalidScreeningIdException;
import touk.recruitment.task.repositories.ScreeningRepository;
import touk.recruitment.task.repositories.entities.ScreeningEntity;

@Service
@AllArgsConstructor
public class ScreeningService {

  private ScreeningRepository screeningRepository;

  public Long getScreeningRoomIdOfScreening(Long screeningId) {
    return getScreeningEntity(screeningId)
        .getRoom()
        .getId();
  }

  public ScreeningEntity getScreeningEntity(Long screeningId) {
    return screeningRepository
        .findById(screeningId)
        .orElseThrow(() -> new InvalidScreeningIdException("No screening with such id"));
  }

}

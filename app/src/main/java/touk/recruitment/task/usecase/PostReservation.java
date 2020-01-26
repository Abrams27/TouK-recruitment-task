package touk.recruitment.task.usecase;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import touk.recruitment.task.models.ReservationResponseDto;
import touk.recruitment.task.models.request.ReservationRequestDto;

@Component
@AllArgsConstructor
public class PostReservation {

  public ResponseEntity<ReservationResponseDto> execute(Long id, ReservationRequestDto request) {
    // todo
    return null;
  }

}

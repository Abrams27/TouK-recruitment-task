package touk.recruitment.task.usecase;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import touk.recruitment.task.models.ReservationResponseDto;
import touk.recruitment.task.models.request.ReservationRequestDto;
import touk.recruitment.task.services.ScreeningAvailableSeatsService;

@Component
@AllArgsConstructor
public class PostReservation {

  private ScreeningAvailableSeatsService screeningAvailableSeatsService;

  public ReservationResponseDto execute(ReservationRequestDto request) {
    screeningAvailableSeatsService.validateSeatsToReservation(request.getScreeningId(), request.getSeats());

    return null;
  }

}

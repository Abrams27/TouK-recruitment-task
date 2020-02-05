package touk.recruitment.task.usecase;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import touk.recruitment.task.mappers.dto.ReservationResponseDtoMapper;
import touk.recruitment.task.models.ReservationResponseDto;
import touk.recruitment.task.models.request.ReservationRequestDto;
import touk.recruitment.task.services.MakeReservationService;
import touk.recruitment.task.services.ScreeningAvailableSeatsService;

@Component
@AllArgsConstructor
public class PostReservation {

  private ScreeningAvailableSeatsService screeningAvailableSeatsService;
  private MakeReservationService makeReservationService;
  private ReservationResponseDtoMapper reservationResponseDtoMapper;

  public ReservationResponseDto execute(ReservationRequestDto request) {
    screeningAvailableSeatsService.validateSeatsToReservation(request.getScreeningId(), request.getSeats());

    return reservationResponseDtoMapper
        .map(makeReservationService
            .makeReservation(request.getScreeningId(), request.getUser(), request.getSeats(), request.getTickets()));
  }

}

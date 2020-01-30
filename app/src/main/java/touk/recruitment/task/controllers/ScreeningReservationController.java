package touk.recruitment.task.controllers;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import touk.recruitment.task.ScreeningReservationApi;
import touk.recruitment.task.models.AvailableScreeningsDto;
import touk.recruitment.task.models.ReservationResponseDto;
import touk.recruitment.task.models.ScreeningRoomDto;
import touk.recruitment.task.models.request.ReservationRequestDto;
import touk.recruitment.task.usecase.GetAvailableScreening;
import touk.recruitment.task.usecase.GetScreeningDetails;
import touk.recruitment.task.usecase.PostReservation;

@RestController
@AllArgsConstructor
public class ScreeningReservationController implements ScreeningReservationApi {

  private GetAvailableScreening getAvailableScreening;
  private GetScreeningDetails getScreeningDetails;
  private PostReservation postReservation;

  @Override
  public List<AvailableScreeningsDto> getAvailableScreening(LocalDate date, LocalTime intervalBeginning, LocalTime intervalEnding) {
    return getAvailableScreening.execute(date, intervalBeginning, intervalEnding);
  }

  @Override
  public ScreeningRoomDto getScreeningDetails(Long id) {
    return getScreeningDetails.execute(id);
  }

  @Override
  public ReservationResponseDto postReservation(ReservationRequestDto request) {
    return postReservation.execute(request);
  }
}

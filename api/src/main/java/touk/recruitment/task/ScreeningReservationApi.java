package touk.recruitment.task;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import touk.recruitment.task.models.AvailableScreeningsDto;
import touk.recruitment.task.models.ScreeningRoomDto;
import touk.recruitment.task.models.request.ReservationRequestDto;
import touk.recruitment.task.models.ReservationResponseDto;

@RequestMapping("/reservation")
public interface ScreeningReservationApi {

  @GetMapping("/available")
  List<AvailableScreeningsDto> getAvailableScreening(
      @RequestParam(required = true) @DateTimeFormat(iso = ISO.DATE) LocalDate date,
      @RequestParam(required = true) @DateTimeFormat(iso = ISO.TIME)LocalTime intervalBeginning,
      @RequestParam(required = true) @DateTimeFormat(iso = ISO.TIME)LocalTime intervalEnding);


  @GetMapping("details/{id}")
  ResponseEntity<ScreeningRoomDto> getScreeningDetails(@PathVariable Long id);


  @PostMapping("new-reservation")
  ResponseEntity<ReservationResponseDto> postReservation(
      @RequestParam(required = true) Long id,
      @RequestBody(required = true) ReservationRequestDto request);

}

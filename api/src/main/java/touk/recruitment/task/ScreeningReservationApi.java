package touk.recruitment.task;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;
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
      @RequestParam(required = true) Date day,
      @RequestParam(required = true) LocalTime intervalBegin,
      @RequestParam(required = true) LocalTime intervalEnd);


  @GetMapping("details/{id}")
  ScreeningRoomDto getScreeningDetails(@PathVariable Long id);


  @PostMapping("new-reservation")
  ReservationResponseDto postReservation(
      @RequestParam(required = true) Long id,
      @RequestBody(required = true) ReservationRequestDto request);

}

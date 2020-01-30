package touk.recruitment.task.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class SeatsAlreadyReservedException extends RuntimeException {

  public SeatsAlreadyReservedException(String message) {
    super(message);
  }
}

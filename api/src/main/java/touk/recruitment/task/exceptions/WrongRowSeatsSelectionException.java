package touk.recruitment.task.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class WrongRowSeatsSelectionException extends RuntimeException {

  public WrongRowSeatsSelectionException(String message) {
    super(message);
  }
}

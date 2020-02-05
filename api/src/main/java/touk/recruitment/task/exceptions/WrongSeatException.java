package touk.recruitment.task.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class WrongSeatException extends RuntimeException {

  public WrongSeatException(String message) {
    super(message);
  }
}

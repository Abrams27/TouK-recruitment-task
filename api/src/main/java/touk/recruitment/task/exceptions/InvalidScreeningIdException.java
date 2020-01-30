package touk.recruitment.task.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class InvalidScreeningIdException extends RuntimeException {

  public InvalidScreeningIdException(String message) {
    super(message);
  }
}

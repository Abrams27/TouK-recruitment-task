package touk.recruitment.task.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReservationResponseDto {

  private BigDecimal totalAmountToPay;
  private LocalDateTime reservationExpirationTime;

}

package touk.recruitment.task.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "reservation.expiration")
public class ReservationExpirationProperties {

  private Long minutesBeforeScreening;
}

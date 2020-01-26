package touk.recruitment.task.usecase;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import touk.recruitment.task.models.ScreeningRoomDto;
import touk.recruitment.task.repository.TickeetTypeRepository;

@Component
@AllArgsConstructor
public class GetScreeningDetails {

  private TickeetTypeRepository xd;

  public ScreeningRoomDto execute(Long id) {
    System.out.println("XDXDDX");
    System.out.println("->>> " + xd.findAll());
    // todo
    return null;
  }

}

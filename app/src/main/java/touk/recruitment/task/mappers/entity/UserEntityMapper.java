package touk.recruitment.task.mappers.entity;

import lombok.experimental.UtilityClass;
import touk.recruitment.task.models.request.UserDto;
import touk.recruitment.task.repositories.entities.reservation.UserEntity;

@UtilityClass
public class UserEntityMapper {

  public UserEntity map(UserDto userDto) {
    return UserEntity.builder()
        .name(userDto.getName())
        .surname(userDto.getSurname())
        .build();
  }

}

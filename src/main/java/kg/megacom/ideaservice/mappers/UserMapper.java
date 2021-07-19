package kg.megacom.ideaservice.mappers;

import kg.megacom.ideaservice.mappers.impl.UserMapperImpl;
import kg.megacom.ideaservice.models.dto.UserDto;
import kg.megacom.ideaservice.models.entity.User;

public interface UserMapper {

    UserMapper INSTANCE = new UserMapperImpl();

    User userDtoToUser(UserDto userDto);
    UserDto userToUserDto(User user);
}

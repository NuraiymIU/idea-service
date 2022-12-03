package kg.megacom.ideaservice.mappers.impl;

import kg.megacom.ideaservice.mappers.UserMapper;
import kg.megacom.ideaservice.models.dto.UserDto;
import kg.megacom.ideaservice.models.entity.User;

public class UserMapperImpl implements UserMapper {
    @Override
    public User userDtoToUser(UserDto userDto) {
        User user = new User();
        if(userDto.getId() != null){
            user.setId(userDto.getId());
        }
        user.setName(userDto.getName());
        user.setPhone(userDto.getPhone());
        return user;
    }

    @Override
    public UserDto userToUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setPhone(user.getPhone());
        return userDto;
    }
}

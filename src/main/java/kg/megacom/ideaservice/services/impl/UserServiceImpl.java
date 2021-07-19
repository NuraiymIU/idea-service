package kg.megacom.ideaservice.services.impl;

import kg.megacom.ideaservice.dao.UserRepo;
import kg.megacom.ideaservice.mappers.UserMapper;
import kg.megacom.ideaservice.models.dto.UserDto;
import kg.megacom.ideaservice.models.entity.User;
import kg.megacom.ideaservice.services.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo){
        this.userRepo = userRepo;
    }
    @Override
    public UserDto save(UserDto userDto) {
        User user = UserMapper.INSTANCE.userDtoToUser(userDto);
        user = userRepo.save(user);

        return UserMapper.INSTANCE.userToUserDto(user);
    }

    @Override
    public UserDto findById(Long id) {
        User user = userRepo.getById(id);
        return UserMapper.INSTANCE.userToUserDto(user);
    }
}

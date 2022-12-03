package kg.megacom.ideaservice.services.impl;

import javassist.NotFoundException;
import kg.megacom.ideaservice.dao.UserRepo;
import kg.megacom.ideaservice.mappers.UserMapper;
import kg.megacom.ideaservice.models.dto.UserDto;
import kg.megacom.ideaservice.models.entity.User;
import kg.megacom.ideaservice.services.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
    public UserDto findById(Long id) throws NotFoundException {
        Optional<User> user = userRepo.findById(id);
        if(!user.isPresent()) {
            throw new NotFoundException(String.format("Пользователь с id %d не найден", id));
        }
        return UserMapper.INSTANCE.userToUserDto(user.get());
    }
}

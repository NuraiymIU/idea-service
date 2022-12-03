package kg.megacom.ideaservice.services;

import javassist.NotFoundException;
import kg.megacom.ideaservice.models.dto.UserDto;

public interface UserService {
    UserDto save(UserDto userDto);

    UserDto findById(Long id) throws NotFoundException;
}

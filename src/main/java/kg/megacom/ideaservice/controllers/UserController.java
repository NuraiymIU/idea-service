package kg.megacom.ideaservice.controllers;

import javassist.NotFoundException;
import kg.megacom.ideaservice.models.dto.UserDto;
import kg.megacom.ideaservice.services.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/save")
    public UserDto saveUser(@RequestBody UserDto userDto){
        return userService.save(userDto);
    }

    @GetMapping("/getById")
    public UserDto findById(@RequestParam Long id) throws NotFoundException {
        return userService.findById(id);
    }
}

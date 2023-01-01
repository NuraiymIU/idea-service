package kg.megacom.ideaservice.controllers;

import javassist.NotFoundException;
import kg.megacom.ideaservice.models.dto.IdeaDto;
import kg.megacom.ideaservice.models.response.ResponseDto;
import kg.megacom.ideaservice.services.IdeaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/idea")
public class IdeaController {
    private IdeaService ideaService;

    public IdeaController(IdeaService ideaService){
        this.ideaService = ideaService;
    }

    @PostMapping("/save")
    public ResponseDto saveIdea(@RequestBody IdeaDto ideaDto) {
        return ideaService.save(ideaDto);
    }

    @GetMapping("/findUserIdeas/{usersId}")
    public List<IdeaDto> findByUserId(@PathVariable Long usersId) throws NotFoundException {
        return ideaService.findAllIdeasByUserId(usersId);
    }

    @GetMapping("/getUserIdeas")
    public List<IdeaDto> getAllUserIdeas(@RequestParam String phone) {
        return ideaService.getIdeasByPhone(phone);
    }

}

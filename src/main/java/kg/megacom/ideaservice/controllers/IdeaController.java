package kg.megacom.ideaservice.controllers;

import kg.megacom.ideaservice.models.dto.IdeaDto;
import kg.megacom.ideaservice.services.IdeaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/idea")
public class IdeaController {
    private IdeaService ideaService;

    public IdeaController(IdeaService ideaService){
        this.ideaService = ideaService;
    }

    @PostMapping("/save")
    public IdeaDto saveIdea(@RequestBody IdeaDto ideaDto){
        return ideaService.save(ideaDto);
    }

}

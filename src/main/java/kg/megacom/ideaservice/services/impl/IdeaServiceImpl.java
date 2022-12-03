package kg.megacom.ideaservice.services.impl;

import javassist.NotFoundException;
import kg.megacom.ideaservice.dao.IdeaRepo;
import kg.megacom.ideaservice.mappers.IdeaMapper;
import kg.megacom.ideaservice.mappers.UserMapper;
import kg.megacom.ideaservice.models.dto.IdeaDto;
import kg.megacom.ideaservice.models.entity.Idea;
import kg.megacom.ideaservice.models.entity.User;
import kg.megacom.ideaservice.services.IdeaService;
import kg.megacom.ideaservice.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IdeaServiceImpl implements IdeaService {
    private IdeaRepo ideaRepo;
    private UserService userService;

    public IdeaServiceImpl(IdeaRepo ideaRepo,
                           UserService userService){
        this.ideaRepo = ideaRepo;
        this.userService = userService;
    }
    @Override
    public IdeaDto save(IdeaDto ideaDto) {
        Idea idea = IdeaMapper.INSTANCE.ideaDtoToIdea(ideaDto);
        idea = ideaRepo.save(idea);
        return IdeaMapper.INSTANCE.ideaToIdeaDto(idea);
    }

    @Override
    public List<IdeaDto> findAllIdeasByUserId(Long usersId) throws NotFoundException {
        User user = UserMapper.INSTANCE.userDtoToUser(userService.findById(usersId));

        List<IdeaDto> ideaDtos = ideaRepo.findAllByUser(user)
                .stream()
                .map(x -> IdeaMapper.INSTANCE.ideaToIdeaDto(x))
                .collect(Collectors.toList());
        return ideaDtos;
    }

}

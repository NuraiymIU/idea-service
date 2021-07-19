package kg.megacom.ideaservice.services.impl;

import kg.megacom.ideaservice.dao.IdeaRepo;
import kg.megacom.ideaservice.mappers.IdeaMapper;
import kg.megacom.ideaservice.models.dto.IdeaDto;
import kg.megacom.ideaservice.models.entity.Idea;
import kg.megacom.ideaservice.services.IdeaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IdeaServiceImpl implements IdeaService {
    private IdeaRepo ideaRepo;

    public IdeaServiceImpl(IdeaRepo ideaRepo){
        this.ideaRepo = ideaRepo;
    }
    @Override
    public IdeaDto save(IdeaDto ideaDto) {
        Idea idea = IdeaMapper.INSTANCE.ideaDtoToIdea(ideaDto);
        idea = ideaRepo.save(idea);
        return IdeaMapper.INSTANCE.ideaToIdeaDto(idea);
    }

}

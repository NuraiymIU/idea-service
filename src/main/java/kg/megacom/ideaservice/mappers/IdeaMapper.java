package kg.megacom.ideaservice.mappers;

import kg.megacom.ideaservice.mappers.impl.IdeaMapperImpl;
import kg.megacom.ideaservice.models.dto.IdeaDto;
import kg.megacom.ideaservice.models.entity.Idea;

public interface IdeaMapper {

    IdeaMapper INSTANCE = new IdeaMapperImpl();

    Idea ideaDtoToIdea(IdeaDto ideaDto);
    IdeaDto ideaToIdeaDto(Idea idea);
}

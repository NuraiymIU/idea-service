package kg.megacom.ideaservice.mappers.impl;

import kg.megacom.ideaservice.mappers.IdeaMapper;
import kg.megacom.ideaservice.mappers.UserMapper;
import kg.megacom.ideaservice.models.dto.IdeaDto;
import kg.megacom.ideaservice.models.entity.Idea;
import kg.megacom.ideaservice.models.entity.User;

public class IdeaMapperImpl implements IdeaMapper {
    @Override
    public Idea ideaDtoToIdea(IdeaDto ideaDto) {

        Idea idea = new Idea();
        User user = UserMapper.INSTANCE.userDtoToUser(ideaDto.getUser());
        idea.setDescription(ideaDto.getDescription());
        idea.setFeedback(ideaDto.isFeedback());
        idea.setUser(user);
        if(ideaDto.getId()!= null){
            idea.setId(ideaDto.getId());
        }
        return idea;
    }

    @Override
    public IdeaDto ideaToIdeaDto(Idea idea) {
        IdeaDto ideaDto = new IdeaDto();
        ideaDto.setId(idea.getId());
        ideaDto.setDescription(idea.getDescription());
        ideaDto.setFeedback(idea.isFeedback());
        ideaDto.setUser(UserMapper.INSTANCE.userToUserDto(idea.getUser()));
        return ideaDto;
    }
}

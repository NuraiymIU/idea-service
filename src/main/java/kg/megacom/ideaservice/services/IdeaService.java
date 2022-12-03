package kg.megacom.ideaservice.services;

import javassist.NotFoundException;
import kg.megacom.ideaservice.models.dto.IdeaDto;

import java.util.List;

public interface IdeaService {
    IdeaDto save(IdeaDto ideaDto);;

    List<IdeaDto> findAllIdeasByUserId(Long usersId) throws NotFoundException;
}

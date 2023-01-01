package kg.megacom.ideaservice.services;

import javassist.NotFoundException;
import kg.megacom.ideaservice.models.dto.IdeaDto;
import kg.megacom.ideaservice.models.response.ResponseDto;

import java.util.List;

public interface IdeaService {
    ResponseDto save(IdeaDto ideaDto);;

    List<IdeaDto> findAllIdeasByUserId(Long usersId) throws NotFoundException;

    List<IdeaDto> getIdeasByPhone(String phone);
}

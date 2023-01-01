package kg.megacom.ideaservice.services.impl;

import javassist.NotFoundException;
import kg.megacom.ideaservice.dao.IdeaRepo;
import kg.megacom.ideaservice.mappers.IdeaMapper;
import kg.megacom.ideaservice.mappers.UserMapper;
import kg.megacom.ideaservice.models.dto.IdeaDto;
import kg.megacom.ideaservice.models.dto.UserDto;
import kg.megacom.ideaservice.models.entity.Idea;
import kg.megacom.ideaservice.models.entity.User;
import kg.megacom.ideaservice.models.response.ResponseDto;
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
    public ResponseDto save(IdeaDto ideaDto) {
        ResponseDto responseDto = new ResponseDto();
        try {
            UserDto userDto = new UserDto();
            userDto.setName(ideaDto.getName());
            userDto.setPhone(ideaDto.getPhone());
            UserDto savedUserDto = userService.save(userDto);
            Idea idea = new Idea();
            idea.setFeedback(ideaDto.isFeedback());
            idea.setDescription(ideaDto.getDescription());
            idea.setUser(UserMapper.INSTANCE.userDtoToUser(savedUserDto));
            idea = ideaRepo.save(idea);
            responseDto.setCode(200);
            if(idea.isFeedback()) {
                responseDto.setMessage("Благодарим за идею, мы в ближайшее время свяжемся с Вами");
            } else {
                responseDto.setMessage("Благодарим за идею");
            }
            return responseDto;
        } catch (Exception e) {
            e.printStackTrace();
            responseDto.setCode(500);
            responseDto.setMessage("Не удалось сохранить идею");
            return responseDto;
        }
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

    @Override
    public List<IdeaDto> getIdeasByPhone(String phone) {
        List<Idea> ideaList = ideaRepo.findAllByUserPhone(phone);
        List<IdeaDto> ideaDtoList = ideaList.stream()
                .map(i -> {
                    IdeaDto ideaDto = new IdeaDto();
                    ideaDto.setId(i.getId());
                    ideaDto.setName(i.getUser().getName());
                    ideaDto.setPhone(i.getUser().getPhone());
                    ideaDto.setDescription(i.getDescription());
                    ideaDto.setFeedback(i.isFeedback());
                    return ideaDto;
                })
                .collect(Collectors.toList());
        return ideaDtoList;
    }

}

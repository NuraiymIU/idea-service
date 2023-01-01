package kg.megacom.ideaservice.models.dto;

import lombok.Data;

@Data
public class IdeaDto {

    private Long id;
    private String name;
    private String phone;
    private String description;
    private boolean feedback;

}

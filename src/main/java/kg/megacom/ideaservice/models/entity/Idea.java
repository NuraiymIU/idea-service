package kg.megacom.ideaservice.models.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "ideas")
public class Idea {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String description;
    private boolean feedback;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

}

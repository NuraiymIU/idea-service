package kg.megacom.ideaservice.models.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String phone;

}

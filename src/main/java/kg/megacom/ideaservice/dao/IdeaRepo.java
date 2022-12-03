package kg.megacom.ideaservice.dao;

import kg.megacom.ideaservice.models.dto.IdeaDto;
import kg.megacom.ideaservice.models.entity.Idea;
import kg.megacom.ideaservice.models.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IdeaRepo extends JpaRepository<Idea, Long> {
    List<Idea> findAllByUser(User user);
}

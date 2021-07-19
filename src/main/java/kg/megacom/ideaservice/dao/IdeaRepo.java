package kg.megacom.ideaservice.dao;

import kg.megacom.ideaservice.models.entity.Idea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdeaRepo extends JpaRepository<Idea, Long> {
}

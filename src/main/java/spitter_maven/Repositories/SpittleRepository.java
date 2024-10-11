package spitter_maven.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spitter_maven.entities.Spittle;

import java.util.List;

@Repository
public interface SpittleRepository extends JpaRepository<Spittle, Long> {
    List<Spittle> findByAuthorId(int authorId);
}

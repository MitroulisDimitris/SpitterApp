package spitter_maven.Repositories;

import org.springframework.stereotype.Repository;
import spitter_maven.entities.Spitter;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface SpitterRepository extends JpaRepository<Spitter, Long> {
    //Spitter findByUsername(String username);
}

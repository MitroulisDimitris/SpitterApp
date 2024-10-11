package spitter_maven.repository;

import org.springframework.stereotype.Repository;
import spitter_maven.entities.Spitter;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface SpitterRepository extends JpaRepository<Spitter, Long> {
    Spitter findByFirstName(String username);
}

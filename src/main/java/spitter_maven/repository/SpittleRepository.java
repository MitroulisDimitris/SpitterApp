package spitter_maven.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spitter_maven.entities.Spitter;
import spitter_maven.entities.Spittle;

import java.util.List;

@Repository
public interface SpittleRepository extends JpaRepository<Spittle, Integer> {
    List<Spittle> findBySpitter(Spitter spitter);
}

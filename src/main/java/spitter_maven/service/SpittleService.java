package spitter_maven.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spitter_maven.Repositories.SpittleRepository;
import spitter_maven.entities.Spittle;

import java.util.List;


@Service
@Transactional
public class SpittleService {

    @Autowired
    private SpittleRepository spittleRepository;

    public Spittle findById(int id) {
        return spittleRepository.findById((long) id).orElse(null);
    }

    public List<Spittle> findAll() {
        return spittleRepository.findAll();
    }

    public void save(Spittle spittle) {
        spittleRepository.save(spittle);
    }

    public void update(Spittle spittle) {
        // The save method can be used for both insert and update
        spittleRepository.save(spittle);
    }

    public void delete(int id) {
        spittleRepository.deleteById((long) id);
    }

    public List<Spittle> findSpittlesByAuthorId(int authorId) {
        return spittleRepository.findByAuthorId(authorId);
    }
}

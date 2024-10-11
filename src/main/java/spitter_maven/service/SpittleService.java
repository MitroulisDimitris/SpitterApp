package spitter_maven.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spitter_maven.entities.Spitter;
import spitter_maven.repository.SpittleRepository;
import spitter_maven.entities.Spittle;

import java.util.List;


@Service
public class SpittleService {


    private final SpittleRepository spittleRepository;

    @Autowired
    public SpittleService(SpittleRepository spittleRepository) {
        this.spittleRepository = spittleRepository;
    }

    @Transactional
    public Spittle findById( int id) {
        return spittleRepository.findById(id).orElse(null);
    }

    @Transactional
    public List<Spittle> findAll() {
        return spittleRepository.findAll();
    }
    @Transactional
    public void save(Spittle spittle) {
        spittleRepository.save(spittle);
    }
    @Transactional
    public void update(Spittle spittle) {
        // The save method can be used for both insert and update
        spittleRepository.save(spittle);
    }

    @Transactional
    public void delete(int id) {
        spittleRepository.deleteById(id);
    }
    @Transactional
    public List<Spittle> findSpittlesBySpitter(Spitter spitter ) {
        return spittleRepository.findBySpitter(spitter);
    }
}

package spitter_maven.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spitter_maven.Repositories.SpitterRepository;
import spitter_maven.entities.Spitter;

import java.util.List;

@Service
@Transactional
public class SpitterService {

    @Autowired
    private SpitterRepository spitterRepository;

    public Spitter findById(int id) {
        return spitterRepository.findById((long) id).orElse(null); // Returns null if not found
    }

    public List<Spitter> findAll() {
        return spitterRepository.findAll();
    }

    public Spitter save(Spitter spitter) {
        return spitterRepository.save(spitter);
    }

    public Spitter update(Spitter spitter) {
        return spitterRepository.save(spitter); // Save will handle both insert and update
    }

    public void delete(int id) {
        spitterRepository.deleteById((long) id);
    }
}


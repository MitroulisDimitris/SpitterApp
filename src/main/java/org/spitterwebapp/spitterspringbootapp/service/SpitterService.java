package org.spitterwebapp.spitterspringbootapp.service;

import org.spitterwebapp.spitterspringbootapp.entities.Spitter;
import org.spitterwebapp.spitterspringbootapp.repository.SpitterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class SpitterService {

    private final SpitterRepository spitterRepository;

    @Autowired
    public SpitterService(SpitterRepository spitterRepository) {
        this.spitterRepository = spitterRepository;
    }
    @Transactional(readOnly = true)
    public Spitter findById(int id) {
        return spitterRepository.findById(id).orElse(null); // Returns null if not found
    }

    @Transactional(readOnly = true)
    public List<Spitter> findAll() {
        return spitterRepository.findAll();
    }
    @Transactional
    public Spitter save(Spitter spitter) {
        return spitterRepository.save(spitter);
    }
    @Transactional
    public Spitter update(Spitter spitter) {
        return spitterRepository.save(spitter); // Save will handle both insert and update
    }
    @Transactional
    public void delete(int id) {
        spitterRepository.deleteById(id);
    }
}


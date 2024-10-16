package org.spitterwebapp.spitterspringbootapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.spitterwebapp.spitterspringbootapp.entities.Spitter;

@Repository
public interface SpitterRepository extends JpaRepository<Spitter, Integer> {
    Spitter findByFirstName(String username);
}

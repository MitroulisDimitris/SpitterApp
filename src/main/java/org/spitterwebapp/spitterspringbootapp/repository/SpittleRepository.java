package org.spitterwebapp.spitterspringbootapp.repository;

import org.spitterwebapp.spitterspringbootapp.entities.Spitter;
import org.spitterwebapp.spitterspringbootapp.entities.Spittle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface SpittleRepository extends JpaRepository<Spittle, Integer> {
    List<Spittle> findBySpitter(Spitter spitter);
}

package com.example.backend.core.application.ports.outbound;

import com.example.backend.core.domain.model.Actor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ActorRepository {
    Optional<Actor> findById(Long id);
    Actor save(Actor actor);
    void deleteById(Long id);
    boolean existsById(Long id);

    List<Actor> findByFilter(String lastName, LocalDateTime lastUpdated, Long actorId);
}

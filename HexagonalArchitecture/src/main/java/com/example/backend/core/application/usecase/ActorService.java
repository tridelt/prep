package com.example.backend.core.application.usecase;

import com.example.backend.core.application.ports.outbound.ActorRepository;
import com.example.backend.core.domain.model.Actor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActorService {

    private final ActorRepository actorRepository;

    public Actor getActorById(Long id) {
        return actorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Actor not found with id " + id));
    }

    public Actor createActor(Actor actor) {
        return actorRepository.save(actor);
    }

    public Actor updateActor(Long id, Actor updated) {
        Actor existing = actorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Actor not found with id " + id));

        existing.setFirstName(updated.getFirstName());
        existing.setLastName(updated.getLastName());
        // apply any domain-specific rules here if needed

        return actorRepository.save(existing);
    }

    public void deleteActor(Long id) {
        if (!actorRepository.existsById(id)) {
            throw new IllegalArgumentException("Actor not found with id " + id);
        }
        actorRepository.deleteById(id);
    }
}

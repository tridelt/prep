package com.example.backend.infrastructure.persistence;

import com.example.backend.core.application.ports.outbound.ActorRepository;
import com.example.backend.infrastructure.persistence.mapper.ActorEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ActorRepositoryAdapter implements ActorRepository {

    private final JpaActorRepository jpa;
    private final ActorEntityMapper mapper;

    @Override
    public Optional<com.example.backend.core.domain.model.Actor> findById(Long id) {
        return jpa.findById(id).map(mapper::toDomain);
    }

    @Override
    public com.example.backend.core.domain.model.Actor save(com.example.backend.core.domain.model.Actor actor) {
        return mapper.toDomain(jpa.save(mapper.toEntity(actor)));
    }

    @Override
    public void deleteById(Long id) {
        jpa.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return jpa.existsById(id);
    }

    @Override
    public List<com.example.backend.core.domain.model.Actor> findByFilter(String lastName, LocalDateTime lastUpdated, Long actorId) {
        return jpa.getFilteredActors(lastName, lastUpdated, actorId)
                .stream()
                .map(mapper::toDomain)
                .toList();
    }
}

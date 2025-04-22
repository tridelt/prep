package com.example.backend.infrastructure.persistence;

import com.example.backend.infrastructure.persistence.entity.ActorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface JpaActorRepository extends JpaRepository<ActorEntity, Long> {

    @Query("SELECT a FROM ActorEntity a WHERE a.lastName = :lastName AND a.lastUpdated = :lastUpdated AND a.actorId > :actorId")
    List<ActorEntity> getFilteredActors(String lastName, LocalDateTime lastUpdated, Long actorId);
}

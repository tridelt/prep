package com.example.backend.repository;

import com.example.backend.model.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ActorRepository extends JpaRepository<Actor,Long> {

    List<Actor> findByLastNameAndLastUpdatedAndActorIdGreaterThan(String lastName, LocalDateTime lastUpdated, Double actorId);

    @Query("SELECT a FROM Actor a WHERE a.lastName = :lastName AND a.lastUpdated = :lastUpdated AND a.actorId > :actorId")
    List<Actor> getFilteredActors(@Param("lastName") String lastName,
                                  @Param("lastUpdated") LocalDateTime lastUpdated,
                                  @Param("actorId") Long actorId);



}

package com.example.backend.infrastructure.persistence.mapper;

import com.example.backend.core.domain.model.Actor;
import com.example.backend.infrastructure.persistence.entity.ActorEntity;
import org.springframework.stereotype.Component;

@Component
public class ActorEntityMapper {

    public Actor toDomain(ActorEntity entity) {
        return new Actor(entity.getActorId(), entity.getFirstName(), entity.getLastName(), entity.getLastUpdated());
    }

    public ActorEntity toEntity(Actor actor) {
        return new ActorEntity(actor.getActorId(), actor.getFirstName(), actor.getLastName(), actor.getLastUpdated());
    }
}



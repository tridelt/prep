package com.example.backend.infrastructure.web.mapper;

import com.example.backend.core.domain.model.Actor;
import com.example.backend.infrastructure.web.dto.ActorDto;
import org.springframework.stereotype.Component;

@Component
public class ActorDtoMapper {

    public Actor toDomain(ActorDto actorDto) {
        return new Actor(actorDto.getActorId(), actorDto.getFirstName(), actorDto.getLastName(), actorDto.getLastUpdated());
    }

    public ActorDto toDto(Actor actor) {
        return new ActorDto(actor.getActorId(), actor.getFirstName(), actor.getLastName(), actor.getLastUpdated());
    }
}

package com.example.backend.model.mapper;

import com.example.backend.model.dto.ActorDto;
import com.example.backend.model.entity.Actor;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ActorMapper {
    ActorDto toDto(Actor actor);
    Actor toEntity(ActorDto dto);

    void updateFromDto(ActorDto dto, @MappingTarget Actor actor);
}


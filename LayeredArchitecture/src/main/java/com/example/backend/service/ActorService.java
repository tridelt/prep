package com.example.backend.service;

import com.example.backend.model.dto.ActorDto;
import com.example.backend.model.entity.Actor;
import com.example.backend.model.mapper.ActorMapper;
import com.example.backend.repository.ActorRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActorService {

    private final ActorMapper actorMapper;
    private final ActorRepository actorRepository;

    public Actor getActorById(Long id) {
        return actorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Actor not found with id " + id));
    }

    public ActorDto createActor(ActorDto actorDto) {
        Actor actor = actorMapper.toEntity(actorDto);

        return actorMapper.toDto(actorRepository.save(actor));
    }

    public ActorDto updateActor(Long id, ActorDto dto) {
        Actor existing = actorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Actor not found with id " + id));

        actorMapper.updateFromDto(dto, existing); // updates fields in-place

        return actorMapper.toDto(actorRepository.save(existing));
    }

    public void deleteActor(Long id) {
        if (!actorRepository.existsById(id)) {
            throw new EntityNotFoundException("Actor not found with id " + id);
        }
        actorRepository.deleteById(id);
    }
}


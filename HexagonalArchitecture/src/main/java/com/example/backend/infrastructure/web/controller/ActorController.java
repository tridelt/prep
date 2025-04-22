package com.example.backend.infrastructure.web.controller;

import com.example.backend.core.application.usecase.ActorService;
import com.example.backend.core.domain.model.Actor;
import com.example.backend.infrastructure.web.dto.ActorDto;
import com.example.backend.infrastructure.web.mapper.ActorDtoMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;


@RestController
@AllArgsConstructor
@RequestMapping("/actor")
public class ActorController {

    private final ActorService actorService;
    private final ActorDtoMapper actorMapper;

    @GetMapping("/{id}")
    public ResponseEntity<ActorDto> getActorById(@PathVariable Long id) {
        // 1) service returns domain Actor
        Actor actor = actorService.getActorById(id);
        // 2) map to DTO
        ActorDto dto = actorMapper.toDto(actor);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<ActorDto> createActor(@RequestBody ActorDto actorDto) {
        // 1) map incoming DTO → domain
        Actor domainToCreate = actorMapper.toDomain(actorDto);
        // 2) call service
        Actor createdDomain = actorService.createActor(domainToCreate);
        // 3) map resulting domain → DTO
        ActorDto createdDto = actorMapper.toDto(createdDomain);
        URI location = URI.create("/actor/" + createdDto.getActorId());
        return ResponseEntity.created(location).body(createdDto);
    }

    @PutMapping("/{actorId}")
    public ResponseEntity<ActorDto> updateActor(
            @PathVariable Long actorId,
            @RequestBody ActorDto actorDto
    ) {
        // 1) map DTO → domain (updated data)
        Actor updatedDomain = actorMapper.toDomain(actorDto);
        // 2) call service with domain object
        Actor savedDomain = actorService.updateActor(actorId, updatedDomain);
        // 3) map domain → DTO
        ActorDto resultDto = actorMapper.toDto(savedDomain);
        return ResponseEntity.ok(resultDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteActor(@PathVariable Long id) {
        actorService.deleteActor(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello World";
    }
}


package com.example.backend.controller;

import com.example.backend.model.dto.ActorDto;
import com.example.backend.model.entity.Actor;
import com.example.backend.model.mapper.ActorMapper;
import com.example.backend.service.ActorService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;


@RestController
@AllArgsConstructor
@RequestMapping(value = "/actor")
public class ActorController {

    private final ActorService actorService;
    private final ActorMapper actorMapper;


    @GetMapping("/{id}")
    public ResponseEntity<ActorDto> getActorById(@PathVariable Long id) {
        Actor actor = actorService.getActorById(id); // fetches the entity
        ActorDto dto = actorMapper.toDto(actor);     // maps to DTO
        return ResponseEntity.ok(dto);               // returns 200 OK + data
    }

    //    create
    @PostMapping
    public ResponseEntity<ActorDto> createActor(@RequestBody ActorDto actorDto) {
        ActorDto createdActorDto = actorService.createActor(actorDto);
        URI location = URI.create("/actors/" + createdActorDto.getActorId());
        return ResponseEntity.created(location).body(createdActorDto);
    }

    //    update
    @PutMapping("/{actorId}")
    public ResponseEntity<ActorDto> updateActor(@PathVariable Long actorId, @RequestBody ActorDto actorDto) {
        return ResponseEntity.ok(actorService.updateActor(actorId, actorDto));
    }

    //    delete
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


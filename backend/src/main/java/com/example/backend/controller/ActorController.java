package com.example.backend.controller;

import com.example.backend.model.dto.ActorDto;
import com.example.backend.model.entity.Actor;
import com.example.backend.model.mapper.ActorMapper;
import com.example.backend.service.ActorService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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

    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello fffff";
    }

}


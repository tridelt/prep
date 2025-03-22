package com.example.backend.model.dto;

import com.example.backend.validation.ValidationGroups;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class ActorDto {

    @Null(groups = {ValidationGroups.IdentityNull.class})
    @NotNull(groups = {ValidationGroups.IdentityPresent.class})
    private Double actorId;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    private LocalDateTime lastUpdated;

}

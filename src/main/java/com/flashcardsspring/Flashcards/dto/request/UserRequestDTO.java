package com.flashcardsspring.Flashcards.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public record UserRequestDTO(@NotNull @NotBlank String name, @NotNull @NotBlank String email, @NotNull @NotBlank String password) {
}

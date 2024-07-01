package com.flashcardsspring.Flashcards.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public record DeckRequestUpdateDTO(@NotNull @NotBlank String name) {
}

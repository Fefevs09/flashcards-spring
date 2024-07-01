package com.flashcardsspring.Flashcards.dto.request;

import com.flashcardsspring.Flashcards.domain.enums.Feedback;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public record CardRequestDTO(@NotNull @NotBlank String question, @NotNull @NotBlank String answer, @NotNull Feedback feedback, @NotNull DeckIdRequestDTO deckIdRequestDTO) {

}
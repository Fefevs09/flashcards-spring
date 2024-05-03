package com.flashcardsspring.Flashcards.dto.request;

import com.flashcardsspring.Flashcards.domain.Deck;
import com.flashcardsspring.Flashcards.domain.enums.Feedback;
import com.flashcardsspring.Flashcards.dto.response.DeckIdResponseDTO;
import com.flashcardsspring.Flashcards.dto.response.DeckResponseDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CardRequestDTO {
    @NotNull
    @NotBlank
    private String question;
    @NotNull
    @NotBlank
    private String answer;
    @NotNull
    private Feedback feedback;
    @NotNull
    private DeckIdResponseDTO deckIdResponseDTO;
}

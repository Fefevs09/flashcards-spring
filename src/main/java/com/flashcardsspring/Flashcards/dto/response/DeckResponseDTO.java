package com.flashcardsspring.Flashcards.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.flashcardsspring.Flashcards.domain.Card;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public record DeckResponseDTO(String deck_id, String name, List<Card> cards) {
}
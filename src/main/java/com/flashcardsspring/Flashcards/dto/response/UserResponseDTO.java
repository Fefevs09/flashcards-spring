package com.flashcardsspring.Flashcards.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public record UserResponseDTO(String id, String name, String email, List<DeckResponseDTO> decks) {
}

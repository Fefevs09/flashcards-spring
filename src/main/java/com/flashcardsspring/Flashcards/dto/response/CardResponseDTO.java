package com.flashcardsspring.Flashcards.dto.response;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.flashcardsspring.Flashcards.domain.enums.Feedback;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public record CardResponseDTO(String id, String question, String answer, Feedback feedback) {
}

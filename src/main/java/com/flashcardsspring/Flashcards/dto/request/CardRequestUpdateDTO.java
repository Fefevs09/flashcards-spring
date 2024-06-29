package com.flashcardsspring.Flashcards.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public record CardRequestUpdateDTO(String question, String answer) {

}

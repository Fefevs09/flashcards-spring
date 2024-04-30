package com.flashcardsspring.Flashcards.dto.response;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.flashcardsspring.Flashcards.domain.enums.Feedback;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CardResponseDTO {
    private String id;
    private String question;
    private String answer;
    private Feedback feedback;
}

package com.flashcardsspring.Flashcards.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CardRequestUpdateDTO {
    private String question;
    private String answer;
}

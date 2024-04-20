package com.flashcardsspring.Flashcards.resources.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StandardError {
    private Integer status;
    private String message;
    private Long timestamp;

}

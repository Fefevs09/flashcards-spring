package com.flashcardsspring.Flashcards.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.flashcardsspring.Flashcards.domain.Card;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DeckResponseDTO {
    private String deck_id;
    private String name;
    private List<Card> cards = new ArrayList<>();
}

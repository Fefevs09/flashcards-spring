package com.flashcardsspring.Flashcards.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.flashcardsspring.Flashcards.domain.Card;
import com.flashcardsspring.Flashcards.domain.User;
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
    private Long deck_id;
    private String name;
    private User user;
    List<Card> cards = new ArrayList<>();
}

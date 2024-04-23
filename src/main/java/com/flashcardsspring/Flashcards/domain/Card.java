package com.flashcardsspring.Flashcards.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flashcardsspring.Flashcards.domain.enums.Feedback;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_card")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "card_id")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long card_id;
    private String question;
    private String answer;
    private Feedback feedback;

    @ManyToOne
    @JoinColumn(name = "deck_id")
    @JsonIgnore
    private Deck deck;
}

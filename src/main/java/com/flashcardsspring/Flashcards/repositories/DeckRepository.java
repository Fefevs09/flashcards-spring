package com.flashcardsspring.Flashcards.repositories;

import com.flashcardsspring.Flashcards.domain.Deck;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeckRepository extends JpaRepository<Deck, Long> {

}

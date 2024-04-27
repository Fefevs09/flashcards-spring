package com.flashcardsspring.Flashcards.repositories;

import com.flashcardsspring.Flashcards.domain.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {
}

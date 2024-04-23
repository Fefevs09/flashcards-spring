package com.flashcardsspring.Flashcards.resources;

import com.flashcardsspring.Flashcards.domain.Card;
import com.flashcardsspring.Flashcards.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "/cards")
public class CardResource {

    @Autowired
    private CardService cardService;


    @GetMapping
    public ResponseEntity<List<Card>> findAll() {
        List<Card> cards = cardService.findAll();
        return ResponseEntity.ok().body(cards);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Card> findById(@PathVariable Long id) {
        Card card = cardService.findById(id);
        return ResponseEntity.ok().body(card);
    }
}

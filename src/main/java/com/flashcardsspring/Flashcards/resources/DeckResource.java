package com.flashcardsspring.Flashcards.resources;

import com.flashcardsspring.Flashcards.domain.Deck;
import com.flashcardsspring.Flashcards.domain.User;
import com.flashcardsspring.Flashcards.services.DeckService;
import com.flashcardsspring.Flashcards.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "/decks")
public class DeckResource {

    @Autowired
    private DeckService deckService;


    @GetMapping
    public ResponseEntity<List<Deck>> findAll() {
        List<Deck> decks = deckService.findAll();
        return ResponseEntity.ok().body(decks);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Deck> findById(@PathVariable Long id) {
        Deck deck = deckService.findById(id);
        return ResponseEntity.ok().body(deck);
    }
}

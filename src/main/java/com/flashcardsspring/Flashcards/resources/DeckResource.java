package com.flashcardsspring.Flashcards.resources;

import com.flashcardsspring.Flashcards.domain.Deck;
import com.flashcardsspring.Flashcards.dto.request.DeckRequestDTO;
import com.flashcardsspring.Flashcards.dto.request.DeckRequestUpdateDTO;
import com.flashcardsspring.Flashcards.dto.response.DeckResponseDTO;
import com.flashcardsspring.Flashcards.services.DeckService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping(value = "/decks")
public class DeckResource {

    @Autowired
    private DeckService deckService;

    @GetMapping
    public ResponseEntity<Page<DeckResponseDTO>> getDecks(Pageable page) {
        var response = deckService.getDecks(page);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<DeckResponseDTO> findById(@PathVariable Long id) {
        var response = deckService.findById(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<DeckResponseDTO> createDeck(@RequestBody @Valid DeckRequestDTO deck, UriComponentsBuilder builder) {
        var response = deckService.createDeck(deck);
        return ResponseEntity.ok(response);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> updateDeck(@PathVariable Long id, @RequestBody @Valid DeckRequestUpdateDTO deck) {
        deckService.updateDeck(id, deck);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteDeck(@PathVariable Long id) {
        deckService.deleteDeck(id);
        return ResponseEntity.noContent().build();
    }
}

package com.flashcardsspring.Flashcards.resources;

import com.flashcardsspring.Flashcards.domain.Card;
import com.flashcardsspring.Flashcards.dto.request.CardRequestDTO;
import com.flashcardsspring.Flashcards.dto.request.CardRequestUpdateDTO;
import com.flashcardsspring.Flashcards.dto.response.CardResponseDTO;
import com.flashcardsspring.Flashcards.dto.response.DeckResponseDTO;
import com.flashcardsspring.Flashcards.services.CardService;
import com.flashcardsspring.Flashcards.services.DeckService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping(value = "/cards")
public class CardResource {

    @Autowired
    private CardService cardService;

    private DeckResponseDTO responseDTO;


    @GetMapping
    public ResponseEntity<Page<CardResponseDTO>> findAll(Pageable page) {
        var response = cardService.findAll(page);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CardResponseDTO> findById(@PathVariable Long id) {
        var response = cardService.findById(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<CardResponseDTO> createCard(@RequestBody @Valid CardRequestDTO card, UriComponentsBuilder builder) {
        CardResponseDTO response = cardService.createCard(card);
        return ResponseEntity.ok(response);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> updateCard(@PathVariable Long id, @RequestBody CardRequestUpdateDTO card) {
        cardService.updateCard(id, card);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteCard(@PathVariable Long id) {
        cardService.deleteCard(id);
        return ResponseEntity.noContent().build();
    }
}

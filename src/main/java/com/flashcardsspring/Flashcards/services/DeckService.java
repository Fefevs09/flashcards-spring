package com.flashcardsspring.Flashcards.services;

import com.flashcardsspring.Flashcards.domain.Deck;
import com.flashcardsspring.Flashcards.repositories.DeckRepository;
import com.flashcardsspring.Flashcards.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeckService {

    @Autowired
    private DeckRepository deckRepository;

    public List<Deck> findAll(){
        return deckRepository.findAll();
    }

    public Deck findById(Long id) {
        Optional<Deck> deck = deckRepository.findById(id);
        if(deck.isEmpty()) {
            throw new ObjectNotFoundException("Deck Não Encontrado! Id: " + id);
        }
        return deck.get();
    }
}

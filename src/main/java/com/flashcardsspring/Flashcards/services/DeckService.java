package com.flashcardsspring.Flashcards.services;

import com.flashcardsspring.Flashcards.domain.Deck;
import com.flashcardsspring.Flashcards.dto.request.DeckRequestDTO;
import com.flashcardsspring.Flashcards.dto.response.DeckResponseDTO;
import com.flashcardsspring.Flashcards.repositories.DeckRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class DeckService {

    @Autowired
    private DeckRepository deckRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Page<DeckResponseDTO> getDecks(Pageable page){
        return deckRepository.findAll(page).map(deck -> modelMapper.map(deck, DeckResponseDTO.class));
    }

    public DeckResponseDTO findById(Long id) {
        var deck = deckRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return modelMapper.map(deck, DeckResponseDTO.class);
    }

    public DeckResponseDTO createDeck(DeckRequestDTO deck) {
        var entity  = deckRepository.save(modelMapper.map(deck, Deck.class));
        return modelMapper.map(entity, DeckResponseDTO.class);
    }
}

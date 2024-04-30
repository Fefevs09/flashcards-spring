package com.flashcardsspring.Flashcards.services;

import com.flashcardsspring.Flashcards.domain.Card;
import com.flashcardsspring.Flashcards.dto.request.CardRequestDTO;
import com.flashcardsspring.Flashcards.dto.response.CardResponseDTO;
import com.flashcardsspring.Flashcards.repositories.CardRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Page<CardResponseDTO> findAll(Pageable page) {
        return cardRepository.findAll(page).map(card -> modelMapper.map(card, CardResponseDTO.class));
    }

    public CardResponseDTO findById(Long id) {
        var card = cardRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return modelMapper.map(card, CardResponseDTO.class);
    }

    public CardResponseDTO createCard(CardRequestDTO card) {
        var entity = cardRepository.save(modelMapper.map(card, Card.class));
        return modelMapper.map(entity, CardResponseDTO.class);
    }
}

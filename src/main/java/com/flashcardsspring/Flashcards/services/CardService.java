package com.flashcardsspring.Flashcards.services;

import com.flashcardsspring.Flashcards.domain.Card;
import com.flashcardsspring.Flashcards.domain.User;
import com.flashcardsspring.Flashcards.repositories.CardRepository;
import com.flashcardsspring.Flashcards.repositories.UserRepository;
import com.flashcardsspring.Flashcards.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;

    public List<Card> findAll(){
        return cardRepository.findAll();
    }

    public Card findById(Long id) {
        Optional<Card> card = cardRepository.findById(id);
        if(card.isEmpty()){
            throw new ObjectNotFoundException("Card Não Encontrado! Id: " + id);
        }
        return card.get();
    }
}

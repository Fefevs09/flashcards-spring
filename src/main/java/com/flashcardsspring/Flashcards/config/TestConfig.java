package com.flashcardsspring.Flashcards.config;

import com.flashcardsspring.Flashcards.domain.Card;
import com.flashcardsspring.Flashcards.domain.Deck;
import com.flashcardsspring.Flashcards.domain.User;
import com.flashcardsspring.Flashcards.domain.enums.Feedback;
import com.flashcardsspring.Flashcards.repositories.CardRepository;
import com.flashcardsspring.Flashcards.repositories.DeckRepository;
import com.flashcardsspring.Flashcards.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DeckRepository deckRepository;

    @Autowired
    private CardRepository cardRepository;

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User();
        user1.setId(null);
        user1.setName("John Doe");
        user1.setEmail("john.doe@gmail.com");
        user1.setPassword("password1");

        User user2 = new User();
        user2.setId(null);
        user2.setName("Jane Doe");
        user2.setEmail("jane.doe@gmail.com");
        user2.setPassword("password2");

        User user3 = new User();
        user3.setId(null);
        user3.setName("Jack Doe");
        user3.setEmail("jack.doe@gmail.com");
        user3.setPassword("password3");

        Deck deck1 = new Deck();
        deck1.setDeck_id(null);
        deck1.setName("Deck 1");
        deck1.setUser(user1);


        Deck deck2 = new Deck();
        deck2.setDeck_id(null);
        deck2.setName("Deck 2");
        deck2.setUser(user2);

        Deck deck3 = new Deck();
        deck3.setDeck_id(null);
        deck3.setName("Deck 3");
        deck3.setUser(user2);


        Card card1 = new Card();
        card1.setCard_id(null);
        card1.setQuestion("Qual é o valor de PI?");
        card1.setAnswer("3.14");
        card1.setFeedback(Feedback.EASY);
        card1.setDeck(deck1);

        Card card2 = new Card();
        card2.setCard_id(null);
        card2.setQuestion("Qual é a raiz quadrada de 25?");
        card2.setAnswer("5");
        card2.setFeedback(Feedback.MEDIUM);
        card2.setDeck(deck1);


        Card card3 = new Card();
        card3.setCard_id(null);
        card3.setQuestion("100 graus correspondem a quantos Farenheit??");
        card3.setAnswer("212 F");
        card3.setFeedback(Feedback.HARD);
        card3.setDeck(deck2);

        Card card4 = new Card();
        card4.setCard_id(null);
        card4.setQuestion("sla?");
        card4.setAnswer("12 S");
        card4.setFeedback(Feedback.EASY);
        card4.setDeck(deck3);

        userRepository.saveAll(Arrays.asList(user1, user2, user3));
        deckRepository.saveAll(Arrays.asList(deck1, deck2, deck3));
        cardRepository.saveAll(Arrays.asList(card1, card2, card3, card4));
    }
}

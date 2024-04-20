package com.flashcardsspring.Flashcards.config;

import com.flashcardsspring.Flashcards.domain.Deck;
import com.flashcardsspring.Flashcards.domain.User;
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


        userRepository.saveAll(Arrays.asList(user1, user2, user3));
        deckRepository.saveAll(Arrays.asList(deck1, deck2, deck3));
    }
}

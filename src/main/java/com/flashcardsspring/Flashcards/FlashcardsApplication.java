package com.flashcardsspring.Flashcards;

import com.flashcardsspring.Flashcards.domain.User;
import com.flashcardsspring.Flashcards.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class FlashcardsApplication{
	public static void main(String[] args) {
		SpringApplication.run(FlashcardsApplication.class, args);
	}
}

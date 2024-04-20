package com.flashcardsspring.Flashcards.repositories;

import com.flashcardsspring.Flashcards.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}

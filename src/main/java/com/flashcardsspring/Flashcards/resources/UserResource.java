package com.flashcardsspring.Flashcards.resources;

import com.flashcardsspring.Flashcards.domain.User;
import com.flashcardsspring.Flashcards.dto.request.UserRequestDTO;
import com.flashcardsspring.Flashcards.dto.request.UserRequestUpdateDTO;
import com.flashcardsspring.Flashcards.dto.response.UserResponseDTO;
import com.flashcardsspring.Flashcards.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;



@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService userService;


    @GetMapping
    public ResponseEntity<Page<UserResponseDTO>> findAll(Pageable page) {
        var response = userService.findAll(page);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserResponseDTO> findById(@PathVariable Long id) {
        var response = userService.findById(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody @Valid UserRequestDTO user, UriComponentsBuilder builder) {
        var response = userService.createUser(user);
        var uri = builder.path("users/{id}").buildAndExpand(response.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> updateUser(@PathVariable Long id, @RequestBody UserRequestUpdateDTO user) {
        userService.updateUser(id, user);
        return ResponseEntity.noContent().build();
    }
}

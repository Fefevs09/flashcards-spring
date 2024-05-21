package com.flashcardsspring.Flashcards.services;

import com.flashcardsspring.Flashcards.domain.User;
import com.flashcardsspring.Flashcards.dto.request.UserRequestDTO;
import com.flashcardsspring.Flashcards.dto.request.UserRequestUpdateDTO;
import com.flashcardsspring.Flashcards.dto.response.UserResponseDTO;
import com.flashcardsspring.Flashcards.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;

    public Page<UserResponseDTO> findAll(Pageable page){
        return userRepository.findAll(page).map(user -> modelMapper.map(user, UserResponseDTO.class));
    }

    public UserResponseDTO findById(Long id) {
        var user = userRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return modelMapper.map(user, UserResponseDTO.class);
    }

    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {
        var entity = userRepository.save(modelMapper.map(userRequestDTO, User.class));
        return modelMapper.map(entity, UserResponseDTO.class);
    }

    public void updateUser(Long id, UserRequestUpdateDTO user) {
        var entity = userRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        modelMapper.map(user, entity);
        userRepository.save(entity);
    }

    public void deleteUser(Long id) {
        var entity = userRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        userRepository.delete(entity);
    }
}

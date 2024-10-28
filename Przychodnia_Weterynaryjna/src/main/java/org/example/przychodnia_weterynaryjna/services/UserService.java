package org.example.przychodnia_weterynaryjna.services;

import lombok.RequiredArgsConstructor;
import org.example.przychodnia_weterynaryjna.repositories.UserRepository;
import org.example.przychodnia_weterynaryjna.models.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    public User registerUser(User user) {
        userRepository.save(user);
        return user;
    }

    public Optional<User>  findUserById(int id) {
        return userRepository.findById(id);

    }
}

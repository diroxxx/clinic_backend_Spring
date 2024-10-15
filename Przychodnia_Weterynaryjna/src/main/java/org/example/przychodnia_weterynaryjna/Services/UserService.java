package org.example.przychodnia_weterynaryjna.Services;

import org.example.przychodnia_weterynaryjna.Repositories.UserRepository;
import org.example.przychodnia_weterynaryjna.models.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(User user) {
        userRepository.save(user);
        return user;
    }

    public Optional<User>  findUserById(int id) {
        return userRepository.findById(id);

    }
}

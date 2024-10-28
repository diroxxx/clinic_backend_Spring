package org.example.przychodnia_weterynaryjna.repositories;

import org.example.przychodnia_weterynaryjna.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}

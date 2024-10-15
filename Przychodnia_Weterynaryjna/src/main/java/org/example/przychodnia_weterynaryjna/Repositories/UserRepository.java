package org.example.przychodnia_weterynaryjna.Repositories;

import org.example.przychodnia_weterynaryjna.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}

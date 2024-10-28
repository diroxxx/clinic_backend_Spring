package org.example.przychodnia_weterynaryjna.repositories;

import org.example.przychodnia_weterynaryjna.models.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Integer> {
}

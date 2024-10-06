package org.example.przychodnia_weterynaryjna.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
public class AnimalType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true, nullable = false, name = "type_name")
    @Size(max = 50)
    private String typeName;

    @OneToMany(mappedBy = "animalType")
    private List<Animal> animals = new ArrayList<>();
}

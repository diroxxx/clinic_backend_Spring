package org.example.przychodnia_weterynaryjna.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(max = 50)
    private String name;

    @ManyToOne
    @JoinColumn(name = "animal_type_id", nullable = false)
    private AnimalType animalType;


    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

}

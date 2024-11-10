package org.example.przychodnia_weterynaryjna.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
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


    public Animal( String name, @NotNull Client client, @NotNull AnimalType animalType) {
        this.name = name;
        this.client = client;
        this.animalType = animalType;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", animalType=" + animalType +
                ", client=" + client +
                '}';
    }
}

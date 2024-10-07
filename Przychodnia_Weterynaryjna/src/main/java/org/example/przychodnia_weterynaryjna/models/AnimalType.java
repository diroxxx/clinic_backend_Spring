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

    @Column(unique = true, nullable = false)
    @Size(max = 50)
    private String type;

    @OneToMany(mappedBy = "animalType")
    private List<Animal> animals = new ArrayList<>();


    public AnimalType(String type) {
        this.type = type;
    }

    public AnimalType() {

    }


    public @Size(max = 50) String getType() {
        return type;
    }

    public void setType(@Size(max = 50) String type) {
        this.type = type;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

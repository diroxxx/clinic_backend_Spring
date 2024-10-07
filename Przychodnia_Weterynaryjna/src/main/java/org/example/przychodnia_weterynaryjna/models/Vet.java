package org.example.przychodnia_weterynaryjna.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Vet {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "years_of_experience")
    @Size(min = 0, max = 2)
    private int yearsOfExperience;

    @OneToOne
    @JoinColumn(name = "user_id", unique = true, nullable = false)
    private User user;

    @OneToMany(mappedBy = "vet", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Appointment> appointments = new ArrayList<>();

    @OneToMany(mappedBy = "vet", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Article> articles = new ArrayList<>();


    public Vet() {
    }

    public Vet(int yearsOfExperience, User user) {
        this.yearsOfExperience = yearsOfExperience;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Size(max = 2)
    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(@Size(max = 2) int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

package org.example.przychodnia_weterynaryjna.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Size(max = 100)
    private String title;

    @NotNull
    @Size(max = 1000)
    private String content;

    @NotNull
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "vet_id", nullable = false)
    private Vet vet;


    public Article() {
    }


    public Article(int id, String title, String content, LocalDateTime date, Vet vet) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.date = date;
        this.vet = vet;
    }

}

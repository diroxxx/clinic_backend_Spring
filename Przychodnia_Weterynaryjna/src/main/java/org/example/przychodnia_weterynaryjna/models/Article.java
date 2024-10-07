package org.example.przychodnia_weterynaryjna.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Date;

@Entity
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
    private Date date;

    @ManyToOne
    @JoinColumn(name = "vet_id", nullable = false)
    private Vet vet;


    public Article() {
    }


    public Article(int id, String title, String content, Date date, Vet vet) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.date = date;
        this.vet = vet;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public @NotNull @Size(max = 100) String getTitle() {
        return title;
    }

    public void setTitle(@NotNull @Size(max = 100) String title) {
        this.title = title;
    }

    public @NotNull @Size(max = 1000) String getContent() {
        return content;
    }

    public void setContent(@NotNull @Size(max = 1000) String content) {
        this.content = content;
    }

    public @NotNull Date getDate() {
        return date;
    }

    public void setDate(@NotNull Date date) {
        this.date = date;
    }

    public Vet getVet() {
        return vet;
    }

    public void setVet(Vet vet) {
        this.vet = vet;
    }
}

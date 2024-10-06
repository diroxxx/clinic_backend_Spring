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

    @ManyToOne
    @JoinColumn(name = "wet_id", nullable = false)
    private Vet wet;

    @NotNull
    @Column(name = "publication_date")
    private Date publicationDate;
}

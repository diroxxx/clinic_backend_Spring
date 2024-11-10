package org.example.przychodnia_weterynaryjna.controllers.DTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data // To Generuje Gettery, Settery i ToStringa i chyba constructor
@AllArgsConstructor
@Builder
public class VetArticleDto {
    private String title;
    private String content;
    private String author;
    private LocalDateTime publicationDate;

    public VetArticleDto() {

    }
}
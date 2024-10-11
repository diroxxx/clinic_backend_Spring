package org.example.przychodnia_weterynaryjna.DTOs;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class VetArticleDto {
    private String title;
    private String content;
    private String author;
    private LocalDateTime publicationDate;

    public VetArticleDto(String title, String content, String author, LocalDateTime publicationDate) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.publicationDate = publicationDate;
    }

    public VetArticleDto() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDateTime getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDateTime publicationDate) {
        this.publicationDate = publicationDate;
    }
}

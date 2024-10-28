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

//    public static void main(String[] args) {
//        VetArticleDto v = new VetArticleDto("tittle", "content", "author", null);
//        VetArticleDto build = VetArticleDto.builder()
//                .author("author")
//                .title("title")
//                .content("content")
//                .build();
//    }

//    public VetArticleDto(String title, String content, String author, LocalDateTime publicationDate) {
//        this.title = title;
//        this.content = content;
//        this.author = author;
//        this.publicationDate = publicationDate;
//    }

    public VetArticleDto() {

    }

//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getContent() {
//        return content;
//    }
//
//    public void setContent(String content) {
//        this.content = content;
//    }
//
//    public String getAuthor() {
//        return author;
//    }
//
//    public void setAuthor(String author) {
//        this.author = author;
//    }
//
//    public LocalDateTime getPublicationDate() {
//        return publicationDate;
//    }
//
//    public void setPublicationDate(LocalDateTime publicationDate) {
//        this.publicationDate = publicationDate;
//    }
}

package org.example.przychodnia_weterynaryjna.services;

import lombok.RequiredArgsConstructor;
import org.example.przychodnia_weterynaryjna.controllers.DTOs.VetArticleDto;
import org.example.przychodnia_weterynaryjna.repositories.ArticleRepository;
import org.example.przychodnia_weterynaryjna.models.Article;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;


    //:TODO mozna tutaj uzyc objectMapper
    public List<VetArticleDto> getAllArticle() {
        return articleRepository.findAll().stream().map(article -> new VetArticleDto(
                 article.getTitle(),
                 article.getContent(),
                 article.getVet().getUser().getFirstName() + " " + article.getVet().getUser().getLastName(),
                 article.getDate()
         )).toList();
    }
}

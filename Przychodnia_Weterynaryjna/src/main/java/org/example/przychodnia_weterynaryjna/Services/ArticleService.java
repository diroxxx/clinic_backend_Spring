package org.example.przychodnia_weterynaryjna.Services;

import org.example.przychodnia_weterynaryjna.DTOs.VetArticleDto;
import org.example.przychodnia_weterynaryjna.Repositories.ArticleRepository;
import org.example.przychodnia_weterynaryjna.models.Article;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {
    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

//    public  VetArticleDto getArticleByTitle(String title) {
//        Optional<Article> article = articleRepository.findByTitle(title);
//        return article.map(value -> new VetArticleDto(
//                value.getTitle(),
//                value.getContent(),
//                value.getVet().getUser().getFirstName() + " " + value.getVet().getUser().getLastName(),
//                value.getDate()
//        )).orElse(null);
//    }

    public List<VetArticleDto> getAllArticle() {
        List<VetArticleDto> articleDtos = new ArrayList<>();
         articleRepository.findAll().forEach(article -> articleDtos.add(new VetArticleDto(
                 article.getTitle(),
                 article.getContent(),
                 article.getVet().getUser().getFirstName() + " " + article.getVet().getUser().getLastName(),
                 article.getDate()
         )));
        return articleDtos;
    }
}

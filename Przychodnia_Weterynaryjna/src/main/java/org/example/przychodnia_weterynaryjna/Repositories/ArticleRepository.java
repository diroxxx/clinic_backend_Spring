package org.example.przychodnia_weterynaryjna.Repositories;

import org.example.przychodnia_weterynaryjna.models.Article;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ArticleRepository extends CrudRepository<Article, Integer> {

    Optional<Article> findByTitle(String title);

}


package org.example.przychodnia_weterynaryjna.repositories;

import org.example.przychodnia_weterynaryjna.models.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Article, Integer> {

    Optional<Article> findByTitle(String title);

}


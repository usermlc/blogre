package com.await.blogactiverecord.controller;

import com.await.blogactiverecord.model.Article;
import com.await.blogactiverecord.repository.ArticleRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Controller for handling article-related API requests
@RestController
@RequestMapping("/articles")
public class ArticleController {

    private final ArticleRepository articleRepository; // Repository for managing articles

    // Constructor for injecting the article repository
    public ArticleController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    // Retrieves all articles from the database
    @GetMapping
    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    // Adds a new article to the database
    @PostMapping
    public ResponseEntity<Article> addArticle(@RequestBody Article article) {
        Article savedArticle = articleRepository.save(article);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedArticle);
    }

    // Retrieves a specific article by its ID
    @GetMapping("/{id}")
    public ResponseEntity<Article> getArticleById(@PathVariable Long id) {
        Optional<Article> article = articleRepository.findById(id);
        return article.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}

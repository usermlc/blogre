package com.await.blogactiverecord.service;

import com.await.blogactiverecord.dto.ArticleDTO;
import com.await.blogactiverecord.exception.ResourceNotFoundException;
import com.await.blogactiverecord.model.Article;
import com.await.blogactiverecord.repository.ArticleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public List<ArticleDTO> getAllArticles() {
        return articleRepository.findAll().stream()
            .map(article -> new ArticleDTO(article.getId(), article.getTitle(), article.getContent(), null))
            .toList();
    }

    public Article createArticle(Article article) {
        return articleRepository.save(article);
    }

    public void deleteArticle(Long id) {
        if (!articleRepository.existsById(id)) {
            throw new ResourceNotFoundException("Article not found with id: " + id);
        }
        articleRepository.deleteById(id);
    }
}

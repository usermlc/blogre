package com.await.blogactiverecord.repository;

import com.await.blogactiverecord.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

// Repository interface for managing Article entities
public interface ArticleRepository extends JpaRepository<Article, Long> {
}

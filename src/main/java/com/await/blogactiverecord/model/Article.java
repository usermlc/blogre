package com.await.blogactiverecord.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Represents an article entity in the database
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generated ID for each article
    private Long id;

    @Column(nullable = false, unique = true) // Title must be unique and not null
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false) // Content stored as text and cannot be null
    private String content;

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL, orphanRemoval = true)
    // List of comments associated with the article, deleted if the article is removed
    private List<Comment> comments;

    // Constructor to create an article with a title and content
    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }
}

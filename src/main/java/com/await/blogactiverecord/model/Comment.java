package com.await.blogactiverecord.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Represents a comment entity in the database
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generated ID for each comment
    private Long id;

    @Column(nullable = false) // Author name cannot be null
    private String author;

    @Column(columnDefinition = "TEXT", nullable = false) // Content stored as text and cannot be null
    private String content;

    @ManyToOne
    @JoinColumn(name = "article_id", nullable = false) // Links the comment to an article
    private Article article;

    // Constructor to create a comment with an author, content, and associated article
    public Comment(String author, String content, Article article) {
        this.author = author;
        this.content = content;
        this.article = article;
    }
}

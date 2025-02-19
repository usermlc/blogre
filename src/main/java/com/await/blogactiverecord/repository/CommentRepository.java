package com.await.blogactiverecord.repository;

import com.await.blogactiverecord.model.Comment;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

// Repository interface for managing Comment entities
public interface CommentRepository extends JpaRepository<Comment, Long> {

    // Retrieves all comments associated with a specific article
    List<Comment> findByArticleId(Long articleId);
}

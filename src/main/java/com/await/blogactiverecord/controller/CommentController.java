package com.await.blogactiverecord.controller;

import com.await.blogactiverecord.model.Comment;
import com.await.blogactiverecord.service.CommentService;
import org.springframework.web.bind.annotation.*;

// Controller for handling comment-related API requests
@RestController
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService; // Service for handling comment operations

    // Constructor for injecting the comment service
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    // Creates a new comment
    @PostMapping
    public Comment createComment(@RequestBody Comment comment) {
        return commentService.createComment(comment);
    }
}

package com.await.blogactiverecord.dto;

// Data Transfer Object (DTO) for representing a comment
public record CommentDTO(Long id, String author, String content) {
}

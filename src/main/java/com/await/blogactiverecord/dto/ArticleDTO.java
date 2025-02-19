package com.await.blogactiverecord.dto;

import java.util.List;

// Data Transfer Object (DTO) for representing an article with its comments
public record ArticleDTO(Long id, String title, String content, List<CommentDTO> comments) {
}

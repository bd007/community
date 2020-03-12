package com.community.community.mapper;

import com.community.community.model.Comment;
import org.springframework.stereotype.Component;

@Component
public interface CommentExtMapper {
    int addCommCount(Comment comment);
}
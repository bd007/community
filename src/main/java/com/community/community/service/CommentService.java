package com.community.community.service;

import com.community.community.exception.CustomizeErrorCode;
import com.community.community.exception.CustomizeException;
import com.community.community.model.Comment;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    public void insert(Comment comment) {
        if (comment.getQuestionId() == null || comment.getQuestionId() == 0) {
            throw new CustomizeException(CustomizeErrorCode.TARGET_PARAM_NOT_FOUND);
        }
    }
}

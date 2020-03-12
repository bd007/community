package com.community.community.dto;

import com.community.community.model.User;
import lombok.Data;

@Data
public class CommentDTO {
    private Long id;
    private Long questionId;
    private Integer type;
    private Long commentator;
    private Long gmtCreate;
    private Long likeCount;
    private String content;
    private Integer commentCount;
    private User user;
}

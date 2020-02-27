package com.community.community.dto;

import lombok.Data;

@Data
public class CommentDTO {
    private Long questionId;
    private Integer type;
    private String content;
}

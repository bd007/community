package com.community.community.mapper;

import com.community.community.model.Question;
import org.springframework.stereotype.Component;

@Component
public interface QuestionExtMapper {
    int addViewCount(Question record);

}
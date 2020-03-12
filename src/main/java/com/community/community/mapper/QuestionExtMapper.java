package com.community.community.mapper;

import com.community.community.model.Question;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface QuestionExtMapper {
    int addViewCount(Question record);

    int addCommCount(Question record);

    List<Question> selectRelated(Question record);
}
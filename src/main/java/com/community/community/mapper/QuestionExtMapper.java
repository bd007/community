package com.community.community.mapper;

import com.community.community.dto.QuestionQueryDTO;
import com.community.community.model.Question;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface QuestionExtMapper {
    int addViewCount(Question record);

    int addCommCount(Question record);

    List<Question> selectRelated(Question record);

    int countBySearch(QuestionQueryDTO record);

    List<Question> selectBySearch(QuestionQueryDTO record);
}
package com.community.community.mapper;

import com.community.community.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface QuestionMapper {

    @Insert("insert into question (title,description,gmt_create,gmt_modified,tag,creator) values (#{title},#{description},#{gmtCreate},#{gmtModified},#{tag},#{creator})")
    void create(Question question);

    @Select("select * from question")
    List<Question> list();
}

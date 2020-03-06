package com.community.community.service;

import com.community.community.dto.CommentDTO;
import com.community.community.enums.CommentTypeEnum;
import com.community.community.exception.CustomizeErrorCode;
import com.community.community.exception.CustomizeException;
import com.community.community.mapper.CommentMapper;
import com.community.community.mapper.QuestionExtMapper;
import com.community.community.mapper.QuestionMapper;
import com.community.community.mapper.UserMapper;
import com.community.community.model.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private QuestionExtMapper questionExtMapper;

    @Autowired
    private UserMapper userMapper;

    @Transactional
    public void insert(Comment comment) {
        if (comment.getQuestionId() == null || comment.getQuestionId() == 0) {
            throw new CustomizeException(CustomizeErrorCode.TARGET_PARAM_NOT_FOUND);
        }
        if (comment.getType() == null || !CommentTypeEnum.isExist(comment.getType())) {
            throw new CustomizeException(CustomizeErrorCode.TYPE_PARAM_WRONG);
        }
        if (comment.getType() == CommentTypeEnum.COMMENT.getType()) {
            //回复评论
            Comment dbcomment = commentMapper.selectByPrimaryKey(comment.getQuestionId());
            if (dbcomment == null) {
                throw new CustomizeException(CustomizeErrorCode.COMMENT_NOT_FOUND);
            }
            commentMapper.insert(comment);
        } else {
            //回复问题
            Question question = questionMapper.selectByPrimaryKey(comment.getQuestionId());
            if (question == null) {
                throw new CustomizeException(CustomizeErrorCode.QUESTION_NOT_FOUND);
            }
            commentMapper.insert(comment);
            question.setCommentCount(1);
            questionExtMapper.addCommCount(question);
        }
    }

    public List<CommentDTO> addComment(Long id) {
        List<CommentDTO> commentDTOS = new ArrayList<>();
        //根据questionId和type去comment表中查
        CommentExample commentExample = new CommentExample();
        commentExample.createCriteria()
                .andQuestionIdEqualTo(id)
                .andTypeEqualTo(1);
        List<Comment> comments = commentMapper.selectByExample(commentExample);
        //根据commentator去user表中查
        for (Comment comment : comments) {
            CommentDTO commentDTO = new CommentDTO();
            UserExample userExample = new UserExample();
            userExample.createCriteria()
                    .andIdEqualTo(comment.getCommentator());
            List<User> users = userMapper.selectByExample(userExample);
            commentDTO.setUser(users.get(0));
            BeanUtils.copyProperties(comment, commentDTO);
            commentDTOS.add(commentDTO);
        }
        return commentDTOS;
    }
}

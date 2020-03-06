package com.community.community.controller;

import com.community.community.dto.CommentDTO;
import com.community.community.dto.QuestionDTO;
import com.community.community.service.CommentService;
import com.community.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private CommentService commentService;

    @GetMapping("question/{id}")
    public String question(@PathVariable(name = "id") Long id,
                           Model model) {

        QuestionDTO questionDTO = questionService.getById(id);
        List<CommentDTO> commentDTOS = commentService.addComment(id);
        questionService.addViewCount(id);
        model.addAttribute("questionDTO", questionDTO);
        model.addAttribute("commentDTOS", commentDTOS);
        return "question";
    }
}

package com.community.community.controller;

import com.community.community.dto.QuestionDTO;
import com.community.community.mapper.QuestionMapper;
import com.community.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;

@Controller
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("question/{id}")
    public String question(HttpServletRequest request,
                           @PathVariable(name="id") Integer id,
                           Model model){

        QuestionDTO questionDTO = questionService.getById(request,id);
        model.addAttribute("questionDTO",questionDTO);
        return "question";
    }
}

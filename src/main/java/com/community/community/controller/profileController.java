package com.community.community.controller;

import com.community.community.dto.PaginationDTO;
import com.community.community.mapper.UserMapper;
import com.community.community.model.User;
import com.community.community.service.NotificationService;
import com.community.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class profileController {

    @Autowired
    UserMapper userMapper;

    @Autowired
    QuestionService questionService;

    @Autowired
    NotificationService notificationService;

    @GetMapping("/profile/{action}")

    public String profile(@PathVariable(name = "action") String action,
                          Model model,
                          HttpServletRequest request,
                          @RequestParam(name = "page", defaultValue = "1") Integer page,
                          @RequestParam(name = "size", defaultValue = "20") Integer size) {
        //user
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            return "redirect:/";
        }
        if ("question".equals(action)) {
            model.addAttribute("section", "question");
            model.addAttribute("sectionName", "我的提问");
            PaginationDTO paginationDTO = questionService.list(user.getId(), page, size);
            model.addAttribute("pagination", paginationDTO);
        } else if ("reply".equals(action)) {
            PaginationDTO paginationDTO = notificationService.list(user.getId(), page, size);
            model.addAttribute("section", "reply");
            model.addAttribute("sectionName", "最新回复");
            model.addAttribute("pagination", paginationDTO);
        }

        return "profile";
    }
}

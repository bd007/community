package com.community.community.advice;

import com.community.community.dto.ResultDTO;
import com.community.community.exception.CustomizeErrorCode;
import com.community.community.exception.CustomizeException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class CustomizeExceptionHandler {

    @ExceptionHandler(Exception.class)
    Object handleControllerException(HttpServletRequest request, Throwable ex, Model model) {
        String ContentType = request.getContentType();
        if ("application/json".equals(ContentType)) {
            if (ex instanceof CustomizeException) {
                return ResultDTO.errorOf((CustomizeException) ex);
            } else {
                return ResultDTO.errorOf(CustomizeErrorCode.SYS_ERROR);
            }
        } else {
            if (ex instanceof CustomizeException) {
                model.addAttribute("message", ex.getMessage());
            } else {
                model.addAttribute("message", CustomizeErrorCode.SYS_ERROR);
            }
            return new ModelAndView("error");
        }
    }

}
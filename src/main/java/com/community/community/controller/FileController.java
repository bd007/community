package com.community.community.controller;

import com.community.community.dto.FileDTO;
import com.community.community.service.OssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class FileController {

    @Autowired
    OssService ossService;

    @ResponseBody
    @RequestMapping(value = "/file/upload", method = RequestMethod.POST)
    public FileDTO uploadFile(HttpServletRequest request) throws Exception {
        return ossService.upload(request);
    }
}

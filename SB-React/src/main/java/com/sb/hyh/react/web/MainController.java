package com.sb.hyh.react.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sb.hyh.react.React;
import com.sb.hyh.react.entity.Comment;
import com.sb.hyh.react.service.CommentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
public class MainController {

    private CommentService service;

    private React react;

    private ObjectMapper mapper;

    @Autowired
    public MainController(CommentService service) {
        this.service = service;
        this.react = new React();
        this.mapper = new ObjectMapper();
    }

    @RequestMapping("/")
    public String index(Map<String, Object> model) throws Exception {
        List<Comment> comments = service.getComments();
        String commentBox = react.renderCommentBox(comments);
        String data = mapper.writeValueAsString(comments);
        model.put("content", commentBox);
        model.put("data", data);
        return "index";
    }
}

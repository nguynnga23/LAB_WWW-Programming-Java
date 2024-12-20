package com.example.controllers;

import com.example.models.Post;
import com.example.services.PostService;
import com.example.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.awt.print.Paper;

@Controller
public class HomeController {
    private final PostService postService;

    @Autowired
    public HomeController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/home")
    public String home(@RequestParam(defaultValue = "0") int page,
                       Model model) {
        Page<Post> posts = postService.findAllOrderedByTitlePageable(page);
        Pager pager = new Pager(posts);
        model.addAttribute("pager", pager);
        return "/home";
    }
}

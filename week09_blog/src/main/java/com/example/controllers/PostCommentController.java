package com.example.controllers;

import com.example.models.PostComment;
import com.example.models.Post;
import com.example.models.User;


import com.example.services.PostCommentService;
import com.example.services.PostService;
import com.example.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.xml.stream.events.Comment;
import java.security.Principal;
import java.util.Optional;

@Controller
public class PostCommentController {
    private final PostCommentService postCommentService;
    private final UserService userService;
    private final PostService postService;

    @Autowired
    public PostCommentController(PostCommentService postCommentService, UserService userService, PostService postService) {
        this.postCommentService = postCommentService;
        this.userService = userService;
        this.postService = postService;
    }

    @RequestMapping(value = "/createComment", method = RequestMethod.POST)
    public String createNewPostComment(@Valid PostComment comment, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/commentForm";
        } else {
            postCommentService.save(comment);
            return "redirect:/post/" + comment.getPost().getId();
        }
    }

    @RequestMapping(value = "/commentPost/{id}", method = RequestMethod.GET)
    public String commentPostWithId(@PathVariable Long id, Principal principal, Model model) {
        Optional<Post> post = postService.findById(id);
        if (post.isPresent()) {
            Optional<User> user = userService.findByEmail(principal.getName());
            if (user.isPresent()) {
                PostComment comment = new PostComment();
                comment.setPost(post.get());
                comment.setUser(user.get());
                model.addAttribute("postComment", comment);
                return "/commentPost";
            } else {
                return "/error";
            }
        } else {
            return "/error";
        }
    }
}


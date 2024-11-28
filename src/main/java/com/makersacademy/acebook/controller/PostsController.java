package com.makersacademy.acebook.controller;

import com.makersacademy.acebook.dto.PostWithData;
import com.makersacademy.acebook.model.Like;
import com.makersacademy.acebook.model.Post;
import com.makersacademy.acebook.repository.LikeRepository;
import com.makersacademy.acebook.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalDateTime;

@Controller
public class PostsController {

    @Autowired
    PostRepository repository;

    @Autowired
    LikeRepository likeRepository;

    private String getCurrentUser() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    @GetMapping("/posts")
    public String index(Model model) {
        Iterable<PostWithData> posts = repository.findAllWithData(getCurrentUser());
        model.addAttribute("posts", posts);
        model.addAttribute("post", new Post());
        model.addAttribute("currentTime", LocalDateTime.now());

        return "posts/index";
    }

    @PostMapping("/posts")
    public RedirectView create(@ModelAttribute Post post) {
        repository.save(post);
        return new RedirectView("/posts");
    }
}

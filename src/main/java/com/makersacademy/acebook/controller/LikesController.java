package com.makersacademy.acebook.controller;

import com.makersacademy.acebook.dto.LikesHandler;
import com.makersacademy.acebook.model.Like;
import com.makersacademy.acebook.repository.LikeRepository;
import com.makersacademy.acebook.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class LikesController {
    @Autowired
    LikeRepository repository;
    @Autowired
    UserRepository userRepository;

    private String getCurrentUser() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    @PostMapping("/likes/{postId}")
    @ResponseBody
    public String create(@PathVariable Long postId) {
        String currentUser = getCurrentUser();
        repository.save(new Like(currentUser, postId));
        LikesHandler likesHandler = new LikesHandler(userRepository, currentUser);
        return likesHandler.getLikedString(postId, true);
    }

    @DeleteMapping("/likes/{postId}")
    @ResponseBody
    public String delete(@PathVariable Long postId) {
        String currentUser = getCurrentUser();
        repository
                .findByUserIdAndPostId(currentUser, postId)
                .ifPresent(like -> repository.delete(like));
        LikesHandler likesHandler = new LikesHandler(userRepository, currentUser);
        return likesHandler.getLikedString(postId, false);
    }
}

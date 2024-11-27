package com.makersacademy.acebook.controller;

import com.makersacademy.acebook.model.Like;
import com.makersacademy.acebook.repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class LikesController {
    @Autowired
    LikeRepository repository;

    private String getCurrentUser() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    @PostMapping("/likes/{postId}")
    public ResponseEntity<?> create(@PathVariable Long postId) {
        repository.save(new Like(getCurrentUser(), postId));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/likes/{postId}")
    public ResponseEntity<?> delete(@PathVariable Long postId) {
        repository
                .findByUserIdAndPostId(getCurrentUser(), postId)
                .ifPresent(like -> repository.delete(like));
        return ResponseEntity.ok().build();
    }
}

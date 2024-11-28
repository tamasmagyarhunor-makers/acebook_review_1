package com.makersacademy.acebook.dto;

import com.makersacademy.acebook.repository.UserRepository;

import java.util.List;

public class CommentsHandler {
    private UserRepository userRepository;
    private String currentUser;

    public CommentsHandler(UserRepository userRepository, String currentUser) {
        this.userRepository = userRepository;
        this.currentUser = currentUser;
    }

    public UserRepository getUserRepository() { return userRepository; }
    public String getCurrentUser() { return currentUser; }

    public void setUserRepository(UserRepository userRepository) { this.userRepository = userRepository; }
    public void setCurrentUser(String currentUser) { this.currentUser = currentUser; }

    public List<CommentWithData> getCommentsWithData(Long postId) {
        return userRepository.findUsersWhoLikedPost(postId);
    }
}

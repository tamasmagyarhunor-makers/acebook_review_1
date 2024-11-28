package com.makersacademy.acebook.service;

import com.makersacademy.acebook.model.User;
import com.makersacademy.acebook.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostDataService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getUsersWhoLiked(Long postId) {
        return userRepository.findUsersWhoLikedPost(postId);
    }
}

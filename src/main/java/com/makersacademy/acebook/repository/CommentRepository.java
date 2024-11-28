package com.makersacademy.acebook.repository;

import com.makersacademy.acebook.model.Comment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentRepository extends CrudRepository<Comment, Long> {
    List<Comment> findByUserId(String userId);
    List<Comment> findByPostId(Long postId);
    List<Comment> findByUserIdAndPostId(String userId, Long postId);

}

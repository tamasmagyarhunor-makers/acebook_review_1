package com.makersacademy.acebook.repository;

import com.makersacademy.acebook.dto.CommentId;
import com.makersacademy.acebook.model.Comment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends CrudRepository<Comment, CommentId> {
    List<Comment> findByUserId(String userId);
    List<Comment> findByPostId(Long postId);
    Optional<Comment> findByUserIdAndPostId(String userId, Long postId);

}

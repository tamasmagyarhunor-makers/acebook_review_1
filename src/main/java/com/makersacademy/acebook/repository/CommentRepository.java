package com.makersacademy.acebook.repository;

import com.makersacademy.acebook.dto.CommentWithData;
import com.makersacademy.acebook.model.Comment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends CrudRepository<Comment, Long> {
    List<Comment> findByUserId(String userId);
    List<Comment> findByPostId(Long postId);
    List<Comment> findByUserIdAndPostId(String userId, Long postId);
    @Query("SELECT new com.makersacademy.acebook.dto.CommentWithData(" +
            "c.id, c.userId, c.postId, c.comments, c.dateTime, u.nickname) " +
            "FROM Comment c " +
            "JOIN User u ON c.userId = u.auth0Id " +
            "WHERE c.postId = :postId " +
            "ORDER BY c.dateTime ASC")
    public List<CommentWithData> findAllCommentsWithData(@Param("postId") Long postId);
}

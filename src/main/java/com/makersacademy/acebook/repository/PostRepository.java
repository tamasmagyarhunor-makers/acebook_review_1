package com.makersacademy.acebook.repository;

import com.makersacademy.acebook.dto.PostWithData;
import com.makersacademy.acebook.model.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PostRepository extends CrudRepository<Post, Long> {
    @Query("SELECT new com.makersacademy.acebook.dto.PostWithData(" +
            "p.id, p.content, p.userId, p.friendsOnly, p.dateTime, u.nickname, " +
            "CASE WHEN l.userId IS NOT NULL THEN true ELSE false END) " +
            "FROM Post p " +
            "JOIN User u ON p.userId = u.auth0Id " +
            "LEFT JOIN Like l ON p.id = l.postId AND l.userId = :userId " +
            "ORDER BY p.dateTime DESC")
    public Iterable<PostWithData> findAllWithData(@Param("userId") String currentUser);
}

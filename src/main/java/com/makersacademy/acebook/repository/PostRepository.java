package com.makersacademy.acebook.repository;

import com.makersacademy.acebook.dto.PostWithNickname;
import com.makersacademy.acebook.model.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {
    @Query("SELECT new com.makersacademy.acebook.dto.PostWithNickname(" +
            "p.id, p.content, p.userId, p.friendsOnly, p.dateTime, u.nickname) " +
            "FROM Post p JOIN User u ON p.userId = u.auth0Id")
    public Iterable<PostWithNickname> findAllWithNicknames();
}

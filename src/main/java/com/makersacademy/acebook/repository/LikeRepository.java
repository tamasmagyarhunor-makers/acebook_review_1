package com.makersacademy.acebook.repository;

import com.makersacademy.acebook.model.Like;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface LikeRepository extends CrudRepository<Like, Long> {
    List<Like> findByUserId(String userId);
    Optional<Like> findByUserIdAndPostId(String userId, Long postId);
}

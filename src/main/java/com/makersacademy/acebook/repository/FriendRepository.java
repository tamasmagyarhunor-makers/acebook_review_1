package com.makersacademy.acebook.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.makersacademy.acebook.model.Friend;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface FriendRepository extends CrudRepository<Friend, Long> {
    //To remove a friend
    @Query("DELETE FROM Friend f WHERE (f.userA = :userA AND f.userB = :userB) OR (f.userA = :userB AND f.userB = :userA)")
    void deleteFriendship(@Param("userA") String userA, @Param("userB") String userB);

    //To check for mutual friends
    @Query("SELECT f FROM Friend f WHERE (f.userA = :userA " +
            "AND f.userB IN (SELECT f2.userB FROM Friend f2 WHERE f2.userA = :userB)) " +
            "OR (f.userB = :userA AND f.userA IN (SELECT f2.userA FROM Friend f2 WHERE f2.userB = :userB))")
    List<FriendRepository> findCommonFriends(@Param("userA") String userA, @Param("userB") String userB );
        }

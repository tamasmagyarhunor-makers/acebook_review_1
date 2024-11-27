package com.makersacademy.acebook.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.makersacademy.acebook.model.Friend;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface FriendsRepository extends CrudRepository<Friend, Long> {
    //To count friends
    @Query("SELECT COUNT(f) FROM Friend f")
    long countTotalFriendships();

    //To remove a friend
    @Query("DELETE FROM Friend f WHERE (f.id.user_a = :userA AND f.id.user_b = :userB) OR (f.id.user_a = :userB AND f.id.user_b = :userA)")
    void deleteFriendship(@Param("userA") String userA, @Param("userB") String userB);

    //To check for mutual friends
    @Query("SELECT f FROM Friend f WHERE (f.id.user_a = :userA " +
            "AND f.id.user_b IN (SELECT f2.id.user_b FROM Friend f2 WHERE f2.id.user_a = :userB)) " +
            "OR (f.id.user_b = :userA AND f.id.user_a IN (SELECT f2.id.user_a FROM Friend f2 WHERE f2.id.user_b = :userB))")
    List<Friend> findCommonFriends(@Param("userA") String user_a, @Param("userB") String user_b );
        }

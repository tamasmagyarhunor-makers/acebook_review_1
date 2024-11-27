package com.makersacademy.acebook.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.makersacademy.acebook.model.Friend;
import org.springframework.data.repository.CrudRepository;


public interface FriendsRepository extends CrudRepository<Friend, Long> {
}

package com.cts.repositray;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cts.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
	
	
	 @Query("SELECT u  FROM User u where u.userName=?1")
	 public User findByUserName(String userName);

}

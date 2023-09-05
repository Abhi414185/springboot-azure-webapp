package com.nagarro.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.assignment.models.User;

public interface UserRepository extends JpaRepository<User,Integer>{
	
	public User findByEmailId(String email);
	
	public User findByEmailIdAndPassword(String EmailId,String password);


}

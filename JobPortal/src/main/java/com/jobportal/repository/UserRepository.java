package com.jobportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jobportal.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	public List<User> findById(int id);

	public User findByemail(String email);

}

package com.jobportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobportal.entities.HR;

public interface HRRepository extends JpaRepository<HR, Integer> {

	HR findByEmail(String email);

}

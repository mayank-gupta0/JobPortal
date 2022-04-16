package com.jobportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobportal.entities.UserAppliedJob;

public interface UserAppliedJobRepository extends JpaRepository<UserAppliedJob, Integer> {

}

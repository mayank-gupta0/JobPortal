package com.jobportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobportal.entities.HRJobPost;

public interface HRJobPostRepository extends JpaRepository<HRJobPost, Integer> {

}

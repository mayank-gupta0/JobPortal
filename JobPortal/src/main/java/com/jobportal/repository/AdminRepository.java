package com.jobportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobportal.entities.AdminApproval;

public interface AdminRepository extends JpaRepository<AdminApproval, Integer> {

}

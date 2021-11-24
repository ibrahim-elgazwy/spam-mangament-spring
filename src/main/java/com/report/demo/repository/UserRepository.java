package com.report.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.report.demo.domain.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findByEmailAndPassword(String email, String password);
}

package com.budgetbuddy.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.budgetbuddy.backend.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}

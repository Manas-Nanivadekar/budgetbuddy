package com.budgetbuddy.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.budgetbuddy.backend.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}

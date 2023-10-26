package com.budgetbuddy.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.budgetbuddy.backend.model.Transaction;
import com.budgetbuddy.backend.repository.TransactionRepository;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction addTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public Transaction getTransaction(Long transactionId) {
        return transactionRepository.findById(transactionId).orElse(null);
    }

    public List<Transaction> getAllTransactions(Long userId) {
        return transactionRepository.findByUserId(userId);
    }

    public List<Transaction> getTransactionsByCategory(String category, Long userId) {
        return transactionRepository.findByCategoryAndUserId(category, userId);
    }
}

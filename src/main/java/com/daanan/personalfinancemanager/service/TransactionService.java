package com.daanan.personalfinancemanager.service;

import com.daanan.personalfinancemanager.model.Transaction;

import java.util.List;

public interface TransactionService {

    Transaction saveTransaction(Transaction transaction);

    List<Transaction> getAllTransactions();

    Transaction getTransactionById(Long transactionId);

    void deleteTransaction(Long transactionId);

    // Add more methods as required, for example, methods to get transactions by user or category
}

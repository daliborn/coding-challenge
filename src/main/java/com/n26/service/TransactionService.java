package com.n26.service;

import com.n26.domain.Statistics;
import com.n26.domain.Transaction;

public interface TransactionService {
    Statistics getStatistics();
    void saveTransaction(Transaction transaction);
    void deleteTransactions();
}

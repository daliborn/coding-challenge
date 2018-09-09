package com.n26.service;

import com.n26.domain.Statistics;
import com.n26.domain.Transaction;

/**
 * Service used to handle transactions and statistics
 */
public interface TransactionService {
    /**
     * @return Statistics
     */
    Statistics getStatistics();

    /**
     * @param transaction
     */
    void saveTransaction(Transaction transaction);

    /**
     *
     */
    void deleteTransactions();
}

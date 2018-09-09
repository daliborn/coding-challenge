package com.n26.util;

import com.n26.domain.Transaction;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

public class TransactionTestFactory {
    public static Transaction createTransaction() {
        Transaction transaction = new Transaction();
        transaction.setAmount(new BigDecimal(100.00));
        transaction.setTimestamp(ZonedDateTime.now());
        return transaction;
    }
}

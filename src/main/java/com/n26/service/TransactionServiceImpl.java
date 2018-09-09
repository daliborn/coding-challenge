package com.n26.service;

import com.n26.domain.Statistics;
import com.n26.domain.Transaction;
import com.n26.util.DurationUtil;
import com.n26.util.StatisticsParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TransactionServiceImpl implements TransactionService {
    private static final Logger log = LoggerFactory.getLogger(TransactionServiceImpl.class);

    private final List<Transaction> transactions = Collections.synchronizedList(new ArrayList<>());

    @Override
    public Statistics getStatistics() {
        DoubleSummaryStatistics stats = transactions.stream()
                .filter(p -> ! DurationUtil.isOlderThanSixtySecondsFromNow(p.getTimestamp()))
                .mapToDouble((x) -> x.getAmount().doubleValue())
                .summaryStatistics();

        return StatisticsParser.parse(stats);
    }

    @Override
    public void saveTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    @Override
    public void deleteTransactions() {
        transactions.clear();
    }

}

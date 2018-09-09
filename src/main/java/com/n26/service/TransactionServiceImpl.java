package com.n26.service;

import com.n26.controllers.TransactionController;
import com.n26.domain.Statistics;
import com.n26.domain.Transaction;
import com.n26.util.DurationUtil;
import com.n26.util.StatisticsParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class TransactionServiceImpl implements TransactionService {
    Logger log = LoggerFactory.getLogger(TransactionServiceImpl.class);

    private List<Transaction> transactions = Collections.synchronizedList(new ArrayList<>());
    private ZonedDateTime lastTimeStamp = ZonedDateTime.now(ZoneId.of("UTC"));

    @Override
    public Statistics getStatistics() {
        DoubleSummaryStatistics stats = transactions.stream()
                .mapToDouble((x) -> x.getAmount().doubleValue()).summaryStatistics();
        return StatisticsParser.parse(stats);
    }

    @Override
    public void saveTransaction(Transaction transaction) {
        if(transaction.getTimestamp().isBefore(lastTimeStamp)){
            lastTimeStamp = transaction.getTimestamp();
        }else if(DurationUtil.isOlderThan(lastTimeStamp)){
//            log.info("size " + transactions.size());
//            //TODO: thread safety
//            transactions.stream().filter( p -> ! DurationUtil.isOlderThan(p.getTimestamp()));
//            log.info("size " + transactions.size());
        }
        transactions.add(transaction);
    }

    @Override
    public void deleteTransactions() {
        //TODO: Not thread safe
        transactions.clear();
    }

}

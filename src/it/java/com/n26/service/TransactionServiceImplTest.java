package com.n26.service;

import com.n26.domain.Statistics;
import com.n26.domain.Transaction;
import com.n26.util.TransactionTestFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.Assert.*;


public class TransactionServiceImplTest {
    private TransactionServiceImpl service;

    @Before
    public void setUp() throws Exception {
        service = new TransactionServiceImpl();
    }


    @Test
    public void getStatistics() {
        Statistics statisticsAfter = service.getStatistics();
        assertEquals(new Integer(0),statisticsAfter.getCount());
    }

    @Test
    public void saveTransaction() {
        Transaction transaction = TransactionTestFactory.createTransaction();
        Statistics statisticsBefore = service.getStatistics();
        assertEquals(new Integer(0),statisticsBefore.getCount());

        service.saveTransaction(transaction);

        Statistics statisticsAfter = service.getStatistics();
        assertEquals(new Integer(1),statisticsAfter.getCount());
    }

    @Test
    public void deleteTransactions() {
        Statistics statisticsBefore = service.getStatistics();
        assertEquals(new Integer(0),statisticsBefore.getCount());

        service.deleteTransactions();

        Statistics statisticsAfter = service.getStatistics();
        assertEquals(new Integer(0),statisticsAfter.getCount());
    }

    @Test
    public void saveTransactionConcurent() throws InterruptedException {
        Statistics statisticsBefore = service.getStatistics();
        assertEquals(new Integer(0),statisticsBefore.getCount());

        service.saveTransaction(TransactionTestFactory.createTransaction());
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Runnable runnableTask = () -> {
            service.saveTransaction(TransactionTestFactory.createTransaction());
        };

        executor.execute(runnableTask);

        Thread.sleep(2000l);
        Statistics statisticsAfter = service.getStatistics();
        assertEquals(new Integer(2),statisticsAfter.getCount());
    }


}
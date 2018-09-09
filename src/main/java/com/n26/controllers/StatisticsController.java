package com.n26.controllers;

import com.n26.domain.Statistics;
import com.n26.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;

@RestController(value = "/statistics")
public class StatisticsController {

    private TransactionService transactionService;

    @Autowired
    public StatisticsController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public ResponseEntity<Statistics> getStatistics() {
        return new ResponseEntity<>(transactionService.getStatistics(), OK);
    }

}

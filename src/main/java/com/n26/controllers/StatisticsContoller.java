package com.n26.controllers;

import com.n26.domain.Statistics;
import com.n26.domain.Transaction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/statistics")
public class StatisticsContoller {


    @GetMapping
    public Statistics getStatistics() {
        return new Statistics();
    }

}

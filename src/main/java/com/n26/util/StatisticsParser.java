package com.n26.util;

import com.n26.domain.Statistics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.DoubleSummaryStatistics;

public class StatisticsParser {
    private final static Logger log = LoggerFactory.getLogger(StatisticsParser.class);
    private StatisticsParser(){}

    public static Statistics parse(DoubleSummaryStatistics stats){
        Statistics statistics = new Statistics();
        statistics.setAvg(parseBigDecimal(stats.getAverage()));
        statistics.setCount(Long.valueOf(stats.getCount()).intValue());
        statistics.setMax(parseBigDecimal(stats.getMax()));
        statistics.setMin(parseBigDecimal(stats.getMin()));
        statistics.setSum(parseBigDecimal(stats.getSum()));
        return statistics;

    }

    private static BigDecimal parseBigDecimal(double value){
        try {
            return BigDecimal.valueOf(value).setScale(2, RoundingMode.HALF_UP);
        } catch (NumberFormatException nfe){
            log.error(value + " can't be parsed");
            return new BigDecimal(0.00).setScale(2, RoundingMode.HALF_UP);
        }

    }
}

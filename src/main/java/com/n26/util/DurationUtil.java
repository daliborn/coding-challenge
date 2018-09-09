package com.n26.util;

import com.n26.service.TransactionServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DurationUtil {
    private final static Logger log = LoggerFactory.getLogger(DurationUtil.class);

    private DurationUtil(){}

    public static boolean isOlderThan(ZonedDateTime timestamp) {
        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("UTC"));

        long seconds = Duration.between(timestamp, now).getSeconds();
        if(seconds >= 60l){
            return true;
        }else{
            return false;
        }
    }
}

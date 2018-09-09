package com.n26.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.time.ZoneId;

import java.time.ZonedDateTime;

public class DurationUtil {
    private final static Logger log = LoggerFactory.getLogger(DurationUtil.class);
    public static final long TIME_FOR_MEASSURE = 60L;

    private DurationUtil(){}

    public static boolean isOlderThanSixtySecondsFromNow(ZonedDateTime timestamp) {
        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("UTC"));

        long seconds = Duration.between(timestamp, now).getSeconds();
        return seconds >= TIME_FOR_MEASSURE;
    }
}

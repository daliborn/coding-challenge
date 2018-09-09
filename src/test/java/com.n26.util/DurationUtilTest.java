package com.n26.util;

import org.junit.Test;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import static org.junit.Assert.*;

public class DurationUtilTest {

    //TODO: investigate location
    @Test
    public void isTransactionOlderThan() {
        ZonedDateTime zdt = ZonedDateTime.now(ZoneId.of("UTC")).minusSeconds(61);

        boolean result = DurationUtil.isOlderThanSixtySecondsFromNow(zdt);

        assertTrue(result);
    }

    @Test
    public void isTransaction() {
        ZonedDateTime zdt = ZonedDateTime.now(ZoneId.of("UTC"));

        boolean result = DurationUtil.isOlderThanSixtySecondsFromNow(zdt);

        assertFalse(result);
    }
}
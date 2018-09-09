package com.n26.domain;

import javax.validation.constraints.PastOrPresent;
import java.math.BigDecimal;
import java.time.ZonedDateTime;

public class Transaction {
    private BigDecimal amount;
    @PastOrPresent
    private ZonedDateTime timestamp;


    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public @PastOrPresent ZonedDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(ZonedDateTime timestamp) {
        this.timestamp = timestamp;
    }
}

package com.n26.domain;

import org.springframework.beans.factory.annotation.Required;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDateTime;

public class Transaction {
    // amount – transaction amount; a string of arbitrary length that is parsable as a BigDecimal
    //timestamp – transaction time in the ISO 8601 format YYYY-MM-DDThh:mm:ss.sssZ in the UTC timezone (this is not the current timestamp)
    @NotBlank
    private String amount;
    @PastOrPresent
    private LocalDateTime timestamp;

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}

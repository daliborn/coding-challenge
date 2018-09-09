package com.n26.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.math.BigDecimal;

public class Statistics {
    private BigDecimal sum;
    private BigDecimal avg;
    private BigDecimal max;
    private BigDecimal min;
    private Integer count;

    public Statistics() {
        this.sum = new BigDecimal(0.00);
        this.avg= new BigDecimal(0.00);
        this.max= new BigDecimal(0.00);
        this.min = new BigDecimal(0.00);
        this.count = 0;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    public BigDecimal getAvg() {
        return avg;
    }

    public void setAvg(BigDecimal avg) {
        this.avg = avg;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    public BigDecimal getMax() {
        return max;
    }

    public void setMax(BigDecimal max) {
        this.max = max;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    public BigDecimal getMin() {
        return min;
    }

    public void setMin(BigDecimal min) {
        this.min = min;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}

package com.n26.domain;

import java.math.BigDecimal;

public class Statistics {
    //  "sum": "1000.00",
    //  "avg": "100.53",
    //  "max": "200000.49",
    //  "min": "50.23",
    //  "count": 10
    private BigDecimal sum;
    private BigDecimal avg;
    private BigDecimal max;
    private BigDecimal min;
    private Integer count;

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    public BigDecimal getAvg() {
        return avg;
    }

    public void setAvg(BigDecimal avg) {
        this.avg = avg;
    }

    public BigDecimal getMax() {
        return max;
    }

    public void setMax(BigDecimal max) {
        this.max = max;
    }

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

package com.progressoft.tools;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class ScoringSummaryImp implements ScoringSummary {

    private final BigDecimal mean;
    private final BigDecimal standardDeviation;
    private final BigDecimal variance;
    private final BigDecimal median;
    private final BigDecimal min;
    private final BigDecimal max;

    public ScoringSummaryImp(BigDecimal mean, BigDecimal standardDeviation, BigDecimal variance, BigDecimal median, BigDecimal min, BigDecimal max) {
        this.mean = mean;
        this.standardDeviation = standardDeviation;
        this.variance = variance;
        this.median = median;
        this.min = min;
        this.max = max;
    }

    @Override
    public BigDecimal mean() {
        return mean.setScale(2,RoundingMode.HALF_EVEN);
    }

    @Override
    public BigDecimal standardDeviation() {
        return standardDeviation.setScale(2,RoundingMode.HALF_EVEN);
    }


    @Override
    public BigDecimal variance() {
        return variance.setScale(2,RoundingMode.HALF_EVEN);
    }

    @Override
    public BigDecimal median() {
        return median.setScale(2,RoundingMode.HALF_EVEN);
    }

    @Override
    public BigDecimal min() {
        return min.setScale(2,RoundingMode.HALF_EVEN);
    }

    @Override
    public BigDecimal max() {
        return max.setScale(2,RoundingMode.HALF_EVEN);
    }
}

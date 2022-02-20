package com.progressoft.tools;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.List;

import static java.math.RoundingMode.*;

public class Calculator {

    public BigDecimal calculateMean(List<BigDecimal> data) {
        BigDecimal sum = BigDecimal.valueOf(0);
        for (BigDecimal element : data) {
            sum = sum.add(element);
        }
        BigDecimal count = BigDecimal.valueOf(data.size());
        BigDecimal vMean = sum.divide(count,0,CEILING);
        return vMean.setScale(2, HALF_EVEN);
    }

    public BigDecimal calculateVariance(List<BigDecimal> data) {
        BigDecimal sum = BigDecimal.valueOf(0);
        BigDecimal vMean = calculateMean(data);
        for (BigDecimal element : data) {
            double difference = Double.parseDouble(String.valueOf(element.subtract(vMean)));
            double pow = Math.pow(difference, 2);
            sum = sum.add(BigDecimal.valueOf(pow));
        }
        BigDecimal vVariance = sum.divide(BigDecimal.valueOf(data.size()),2,HALF_EVEN);

        return vVariance.setScale(0,RoundingMode.CEILING).setScale(2, HALF_EVEN);
    }

    public BigDecimal calculateStandardDeviation(List<BigDecimal> data) {
        BigDecimal vStandardDeviation = BigDecimal.valueOf(Math.sqrt(Double.parseDouble(String.valueOf(calculateVariance(data)))));
        return vStandardDeviation.setScale(2, HALF_EVEN);
    }

    public BigDecimal calculateMedian(List<BigDecimal> data) {
        Collections.sort(data);
        return data.get(data.size()/2);
    }

    public BigDecimal calculateMinValue(List<BigDecimal> data) {
        Collections.sort(data);
        BigDecimal vMin = data.get(0);
        return vMin.setScale(2, HALF_EVEN);
    }

    public BigDecimal calculateMaxValue(List<BigDecimal> data) {
        Collections.sort(data);
        int lastIndex = data.size()-1;
        BigDecimal vMin = data.get(lastIndex);
        return vMin.setScale(2, HALF_EVEN);
    }

    public BigDecimal calculateZscore(BigDecimal mark, BigDecimal mean, BigDecimal std) {
        return mark.subtract(mean).divide(std,2,HALF_EVEN);
    }

    public BigDecimal calculateMinMaxScaling(BigDecimal value, BigDecimal min, BigDecimal max) {
        return value.subtract(min).divide(max.subtract(min),2,HALF_EVEN);
    }
}

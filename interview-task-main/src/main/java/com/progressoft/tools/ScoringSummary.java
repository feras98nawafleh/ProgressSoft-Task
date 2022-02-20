package com.progressoft.tools;

import java.math.BigDecimal;

public interface ScoringSummary {
     BigDecimal mean();

     BigDecimal standardDeviation();

     BigDecimal variance();

     BigDecimal median();

     BigDecimal min();

     BigDecimal max();
}

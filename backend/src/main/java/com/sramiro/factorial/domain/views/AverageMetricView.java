package com.sramiro.factorial.domain.views;

import java.time.LocalDateTime;

public interface AverageMetricView {
    long getCount();

    String getName();

    LocalDateTime getPeriod();

    double getAverage();
}

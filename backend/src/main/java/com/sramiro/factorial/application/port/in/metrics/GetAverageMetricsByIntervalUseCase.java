package com.sramiro.factorial.application.port.in.metrics;

import com.sramiro.factorial.domain.enums.Interval;
import com.sramiro.factorial.domain.model.Metric;

import java.util.List;

public interface GetAverageMetricsByIntervalUseCase {
    List<Metric> getAverageMetricsByInterval(Interval interval);
}

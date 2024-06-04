package com.sramiro.factorial.application.port.in.metrics;

import com.sramiro.factorial.domain.enums.Interval;
import com.sramiro.factorial.domain.views.AverageMetricView;

import java.util.List;

public interface GetAverageMetricsByIntervalUseCase {
    List<AverageMetricView> getAverageMetricsByInterval(Interval interval);
}

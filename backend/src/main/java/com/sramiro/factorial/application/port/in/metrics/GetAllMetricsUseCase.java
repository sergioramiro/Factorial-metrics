package com.sramiro.factorial.application.port.in.metrics;

import com.sramiro.factorial.domain.model.Metric;

import java.util.List;

public interface GetAllMetricsUseCase {
    List<Metric> getAllMetrics();
}

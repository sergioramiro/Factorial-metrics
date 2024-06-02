package com.sramiro.factorial.application.port.in;

import com.sramiro.factorial.application.dto.MetricDTO;

import java.util.List;

public interface MetricUseCase {
    MetricDTO createMetric(MetricDTO metricDTO);

    List<MetricDTO> getAllMetrics();

    // TODO: Use the Enum Interval instead of String.
    List<MetricDTO> getAverageMetricsByInterval(String interval);
}

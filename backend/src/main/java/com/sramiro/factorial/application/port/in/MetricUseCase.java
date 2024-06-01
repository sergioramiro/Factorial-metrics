package com.sramiro.factorial.application.port.in;

import com.sramiro.factorial.application.dto.MetricDTO;
import com.sramiro.factorial.application.port.out.Interval;

import java.util.List;

public interface MetricUseCase {
    MetricDTO createMetric(MetricDTO metricDTO);

    List<MetricDTO> getAllMetrics();

    List<MetricDTO> getAverageMetricsByInterval(String interval);
}

package com.sramiro.factorial.application.port.in;

import com.sramiro.factorial.application.dto.MetricDTO;

import java.util.List;

public interface MetricUseCase {
    MetricDTO createMetric(MetricDTO metricDTO);

    List<MetricDTO> getMetrics();
}

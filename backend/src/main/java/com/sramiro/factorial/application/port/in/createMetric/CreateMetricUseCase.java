package com.sramiro.factorial.application.port.in.createMetric;

import com.sramiro.factorial.application.dto.MetricDTO;

public interface CreateMetricUseCase {
    MetricDTO createMetric(MetricDTO metricDTO);

}

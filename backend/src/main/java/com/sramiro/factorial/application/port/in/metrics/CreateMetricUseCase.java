package com.sramiro.factorial.application.port.in.metrics;

import com.sramiro.factorial.application.dto.MetricDTO;
import com.sramiro.factorial.domain.model.Metric;

public interface CreateMetricUseCase {
    Metric createMetric(MetricDTO metricDTO);

}

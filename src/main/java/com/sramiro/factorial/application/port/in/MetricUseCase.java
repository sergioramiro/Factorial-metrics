package com.sramiro.factorial.application.port.in;

import com.sramiro.factorial.application.dto.MetricDTO;

public interface MetricUseCase {
    MetricDTO createMetric(MetricDTO metricDTO);

}

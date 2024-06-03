package com.sramiro.factorial.application.port.in.getAllMetrics;

import com.sramiro.factorial.application.dto.MetricDTO;

import java.util.List;

public interface GetAllMetricsUseCase {
    List<MetricDTO> getAllMetrics();
}

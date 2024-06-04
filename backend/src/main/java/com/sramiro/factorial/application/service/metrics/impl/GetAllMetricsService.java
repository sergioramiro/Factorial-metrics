package com.sramiro.factorial.application.service.metrics.impl;

import com.sramiro.factorial.application.port.in.metrics.GetAllMetricsUseCase;
import com.sramiro.factorial.application.port.out.MetricRepository;
import com.sramiro.factorial.application.service.mapper.MetricMapper;
import com.sramiro.factorial.domain.model.Metric;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllMetricsService implements GetAllMetricsUseCase {

    private final MetricRepository metricRepository;
    private final MetricMapper metricMapper;

    @Override
    public List<Metric> getAllMetrics() {
        return metricRepository.findAll();
    }

}
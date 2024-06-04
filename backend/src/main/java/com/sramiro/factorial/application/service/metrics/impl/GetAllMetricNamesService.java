package com.sramiro.factorial.application.service.metrics.impl;

import com.sramiro.factorial.application.port.in.metrics.GetAllMetricNamesUseCase;
import com.sramiro.factorial.application.port.out.MetricRepository;
import com.sramiro.factorial.application.service.mapper.MetricMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllMetricNamesService implements GetAllMetricNamesUseCase {

    private final MetricRepository metricRepository;
    private final MetricMapper metricMapper;

    @Override
    public List<String> getAllMetricNames() {
        return List.of();
    }
}

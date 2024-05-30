package com.sramiro.factorial.application.service;

import com.sramiro.factorial.application.dto.MetricDTO;
import com.sramiro.factorial.application.port.in.MetricUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MetricService implements MetricUseCase {
    @Override
    public MetricDTO saveMetric(MetricDTO metricDTO) {
        return metricDTO;
    }
}

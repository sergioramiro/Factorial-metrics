package com.sramiro.factorial.application.service.metrics.impl;

import com.sramiro.factorial.application.port.in.metrics.DeleteMetricByIdUseCase;
import com.sramiro.factorial.application.port.out.MetricRepository;
import com.sramiro.factorial.application.service.mapper.MetricMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteMetricByIdService implements DeleteMetricByIdUseCase {

    private final MetricRepository metricRepository;
    private final MetricMapper metricMapper;

    @Override
    public void deleteMetricById(Long id) {
        metricRepository.deleteById(id);
    }
}

package com.sramiro.factorial.application.service.impl;

import com.sramiro.factorial.application.dto.MetricDTO;
import com.sramiro.factorial.application.port.in.createMetric.CreateMetricUseCase;
import com.sramiro.factorial.application.port.out.MetricRepository;
import com.sramiro.factorial.application.service.mapper.MetricMapper;
import com.sramiro.factorial.domain.model.Metric;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateMetricService implements CreateMetricUseCase {

    private final MetricRepository metricRepository;
    private final MetricMapper metricMapper;

    @Override
    public MetricDTO createMetric(MetricDTO metricDTO) {
        Metric save = metricRepository.save(metricMapper.toMetric(metricDTO));

        return metricMapper.toMetricDto(save);
    }

}
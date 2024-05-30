package com.sramiro.factorial.application.service;

import com.sramiro.factorial.application.dto.MetricDTO;
import com.sramiro.factorial.application.port.in.MetricUseCase;
import com.sramiro.factorial.application.port.out.MetricRepository;
import com.sramiro.factorial.domain.model.Metric;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MetricService implements MetricUseCase {

    private final MetricRepository metricRepository;


    @Override
    public MetricDTO saveMetric(MetricDTO metricDTO) {
        Metric save = metricRepository.save(
                Metric.builder()
                        .timestamp(metricDTO.getTimestamp())
                        .name(metricDTO.getName())
                        .value(metricDTO.getValue())
                        .build());

        return MetricDTO.builder()
                .value(save.getValue())
                .timestamp(save.getTimestamp())
                .name(save.getName())
                .build();
    }
}

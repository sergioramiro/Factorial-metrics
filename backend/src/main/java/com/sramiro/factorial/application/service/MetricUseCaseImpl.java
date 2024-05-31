package com.sramiro.factorial.application.service;

import com.sramiro.factorial.application.dto.MetricDTO;
import com.sramiro.factorial.application.port.in.MetricUseCase;
import com.sramiro.factorial.application.port.out.MetricRepository;
import com.sramiro.factorial.application.service.mapper.MetricMapper;
import com.sramiro.factorial.domain.model.Metric;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MetricUseCaseImpl implements MetricUseCase {

    private final MetricRepository metricRepository;

    @Override
    public MetricDTO createMetric(MetricDTO metricDTO) {
        Metric save = metricRepository.save(MetricMapper.dtoToMetric(metricDTO));

        return MetricMapper.metricToDto(save);
    }

    @Override
    public List<MetricDTO> getMetrics() {
        List<Metric> metrics = metricRepository.findAll();
        return metrics.stream()
                .map(metric -> MetricDTO.builder().name(metric.getName()).value(metric.getValue()).timestamp(metric.getTimestamp()).build())
                .toList();
    }
}
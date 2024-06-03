package com.sramiro.factorial.application.service;

import com.sramiro.factorial.application.dto.MetricDTO;
import com.sramiro.factorial.application.port.in.MetricUseCase;
import com.sramiro.factorial.application.port.out.Interval;
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
    private final MetricMapper metricMapper;

    @Override
    public MetricDTO createMetric(MetricDTO metricDTO) {
        Metric save = metricRepository.save(metricMapper.toMetric(metricDTO));

        return metricMapper.toMetricDto(save);
    }

    @Override
    public List<MetricDTO> getAllMetrics() {
        List<Metric> metrics = metricRepository.findAll();
        return metrics.stream()
                .map(metric -> MetricDTO.builder().name(metric.getName()).value(metric.getValue()).timestamp(metric.getTimestamp()).build())
                .toList();
    }

    @Override
    public List<MetricDTO> getAverageMetricsByInterval(Interval interval) {
        List<Metric> averageMetricsByInterval = metricRepository.getAverageMetricsByInterval(interval.getInterval());
        return averageMetricsByInterval.stream()
                .map(metric -> MetricDTO.builder().name(metric.getName()).value(metric.getValue()).timestamp(metric.getTimestamp()).build())
                .toList();
    }
}
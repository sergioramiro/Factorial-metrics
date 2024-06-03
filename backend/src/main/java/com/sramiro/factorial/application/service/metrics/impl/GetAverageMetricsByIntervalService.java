package com.sramiro.factorial.application.service.metrics.impl;

import com.sramiro.factorial.application.port.in.metrics.GetAverageMetricsByIntervalUseCase;
import com.sramiro.factorial.application.port.out.MetricRepository;
import com.sramiro.factorial.application.service.mapper.MetricMapper;
import com.sramiro.factorial.domain.enums.Interval;
import com.sramiro.factorial.domain.model.Metric;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAverageMetricsByIntervalService implements GetAverageMetricsByIntervalUseCase {

    private final MetricRepository metricRepository;
    private final MetricMapper metricMapper;


    @Override
    public List<Metric> getAverageMetricsByInterval(Interval interval) {
        return metricRepository.getAverageMetricsByInterval(interval.getInterval());
    }
}
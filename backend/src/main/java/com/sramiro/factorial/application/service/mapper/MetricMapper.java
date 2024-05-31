package com.sramiro.factorial.application.service.mapper;

import com.sramiro.factorial.application.dto.MetricDTO;
import com.sramiro.factorial.domain.model.Metric;

public class MetricMapper {
    public static MetricDTO metricToDto(Metric metric) {
        return MetricDTO.builder()
                .timestamp(metric.getTimestamp())
                .name(metric.getName())
                .value(metric.getValue())
                .build();
    }

    public static Metric dtoToMetric(MetricDTO dto) {
        return Metric.builder()
                .timestamp(dto.getTimestamp())
                .name(dto.getName())
                .value(dto.getValue())
                .build();
    }
}

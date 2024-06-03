package com.sramiro.factorial.application.service.impl;

import com.sramiro.factorial.application.dto.MetricDTO;
import com.sramiro.factorial.application.port.out.MetricRepository;
import com.sramiro.factorial.application.service.mapper.MetricMapper;
import com.sramiro.factorial.application.service.mapper.MetricMapperImpl;
import com.sramiro.factorial.domain.model.Metric;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@RequiredArgsConstructor
class CreateMetricServiceTest {
    public static final String METRIC = "metric";

    @Mock
    private MetricRepository metricRepository;

    @InjectMocks
    private CreateMetricService service;

    @Spy
    private MetricMapper metricMapper = new MetricMapperImpl();

    @Test
    void CreateMetric_ShouldReturnValidMetricDTO() {
        // Given
        MetricDTO metricDTO = getMetricDTO(METRIC, 10.0, LocalDateTime.now());

        when(metricRepository.save(any(Metric.class))).thenReturn(new MetricMapperImpl().toMetric(metricDTO));

        // When
        MetricDTO result = service.createMetric(metricDTO);

        // Then
        assertEquals(metricDTO.getTimestamp(), result.getTimestamp());
        assertEquals(metricDTO.getName(), result.getName());
        assertEquals(metricDTO.getValue(), result.getValue());
    }

    @Test
    void CreateMetric_ShouldCreateMetricAndReturnDTO() {
        // Given
        MetricDTO metricDTO = getMetricDTO(METRIC, 5.0, LocalDateTime.now());

        when(metricRepository.save(any(Metric.class))).thenReturn(new MetricMapperImpl().toMetric(metricDTO));

        // When
        MetricDTO result = service.createMetric(metricDTO);

        // Then
        assertEquals(metricDTO.getTimestamp(), result.getTimestamp());
        assertEquals(metricDTO.getName(), result.getName());
        assertEquals(metricDTO.getValue(), result.getValue());

        verify(metricRepository, times(1)).save(any(Metric.class));

    }

    private static MetricDTO getMetricDTO(String name, double value, LocalDateTime timestamp) {
        return MetricDTO.builder()
                .name(name)
                .value(value)
                .timestamp(timestamp)
                .build();
    }
}
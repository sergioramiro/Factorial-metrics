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
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@RequiredArgsConstructor
class GetAllMetricsServiceTest {


    public static final String METRIC = "metric";

    @Mock
    private MetricRepository metricRepository;

    @InjectMocks
    private GetAllMetricsService service;

    @Spy
    private MetricMapper metricMapper = new MetricMapperImpl();

    @Test
    void getAllMetrics_ShouldReturnListOfDTOs() {
        // Given
        List<Metric> metrics = new ArrayList<>();

        metrics.add(Metric.builder().id(1L).name("metric1").value(10.0).timestamp(LocalDateTime.now()).build());
        metrics.add(Metric.builder().id(2L).name("metric2").value(15.0).timestamp(LocalDateTime.now()).build());

        when(metricRepository.findAll()).thenReturn(metrics);

        // When
        List<MetricDTO> result = service.getAllMetrics();

        // Then
        assertNotNull(result);
        assertEquals(metrics.size(), result.size());
        verify(metricRepository, times(1)).findAll();
    }
}
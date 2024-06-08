package com.sramiro.factorial.application.service.metrics.impl;

import com.sramiro.factorial.application.port.in.interactor.GetAllMetricsImpl;
import com.sramiro.factorial.application.port.out.MetricRepository;
import com.sramiro.factorial.domain.model.Metric;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class GetAllMetricsImplTest {


    public static final String METRIC = "metric";

    @Mock
    private MetricRepository metricRepository;

    @InjectMocks
    private GetAllMetricsImpl service;

    @Test
    void getAllMetrics_ShouldReturnListOfDTOs() {
        // Given
        List<Metric> metrics = new ArrayList<>();

        metrics.add(Metric.builder().id(1L).name("metric1").value(10.0).timestamp(LocalDateTime.now()).build());
        metrics.add(Metric.builder().id(2L).name("metric2").value(15.0).timestamp(LocalDateTime.now()).build());

        when(metricRepository.findAll()).thenReturn(metrics);

        // When
        List<Metric> result = service.execute();

        // Then
        assertNotNull(result);
        assertEquals(metrics.size(), result.size());
        verify(metricRepository, times(1)).findAll();
    }
}
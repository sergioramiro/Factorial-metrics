package com.sramiro.factorial.application.service.impl;

import com.sramiro.factorial.application.port.out.MetricRepository;
import com.sramiro.factorial.application.service.mapper.MetricMapper;
import com.sramiro.factorial.application.service.mapper.MetricMapperImpl;
import com.sramiro.factorial.application.service.metrics.impl.GetAverageMetricsByIntervalService;
import com.sramiro.factorial.domain.enums.Interval;
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
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@RequiredArgsConstructor
class GetAverageMetricsByIntervalServiceTest {

    public static final String METRIC = "metric";

    @Mock
    private MetricRepository metricRepository;

    @InjectMocks
    private GetAverageMetricsByIntervalService service;

    @Spy
    private MetricMapper metricMapper = new MetricMapperImpl();


    @Test
    void getAverageMetricsByInterval_ShouldCallRepositoryAndReturnListOfDTOs() {
        // Given
        List<Metric> metrics = new ArrayList<>();

        LocalDateTime time = LocalDateTime.now();
        metrics.add(Metric.builder().id(1L).name("metric1").value(10.0).timestamp(time).build());
        metrics.add(Metric.builder().id(2L).name("metric2").value(15.0).timestamp(time).build());

        when(metricRepository.getAverageMetricsByInterval(Interval.MINUTE.getInterval())).thenReturn(metrics);

        // When
        List<Metric> result = service.getAverageMetricsByInterval(Interval.MINUTE);

        // Then
        assertEquals(2, result.size());
        assertEquals(time, result.get(0).getTimestamp());
        assertEquals("metric1", result.get(0).getName());
        assertEquals(10.0, result.get(0).getValue());

        assertEquals(time, result.get(1).getTimestamp());
        assertEquals("metric2", result.get(1).getName());
        assertEquals(15.0, result.get(1).getValue());

        verify(metricRepository, times(1)).getAverageMetricsByInterval(Interval.MINUTE.getInterval());

    }

}
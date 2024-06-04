package com.sramiro.factorial.application.service.impl;

import com.sramiro.factorial.application.port.out.MetricRepository;
import com.sramiro.factorial.application.service.mapper.MetricMapper;
import com.sramiro.factorial.application.service.mapper.MetricMapperImpl;
import com.sramiro.factorial.application.service.metrics.impl.GetAverageMetricsByIntervalService;
import com.sramiro.factorial.domain.enums.Interval;
import com.sramiro.factorial.domain.model.AverageMetric;
import com.sramiro.factorial.domain.views.AverageMetricView;
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
        AverageMetric metric1 = AverageMetric.builder().name("NAME_1").average(11.5).period(time).build();
        AverageMetric metric2 = AverageMetric.builder().name("NAME_2").average(22.5).period(time.plusMinutes(1L)).build();

        List<AverageMetricView> listMetrics = List.of(metric1, metric2);
        when(metricRepository.getAverageMetricsByInterval(Interval.MINUTE.getInterval())).thenReturn(listMetrics);

        // When
        List<AverageMetricView> result = service.getAverageMetricsByInterval(Interval.MINUTE);

        // Then
        assertEquals(2, result.size());
        assertEquals(time, result.get(0).getPeriod());
        assertEquals("NAME_1", result.get(0).getName());
        assertEquals(11.5, result.get(0).getAverage());

        assertEquals(time.plusMinutes(1L), result.get(1).getPeriod());
        assertEquals("NAME_2", result.get(1).getName());
        assertEquals(22.5, result.get(1).getAverage());

        verify(metricRepository, times(1)).getAverageMetricsByInterval(Interval.MINUTE.getInterval());

    }

}
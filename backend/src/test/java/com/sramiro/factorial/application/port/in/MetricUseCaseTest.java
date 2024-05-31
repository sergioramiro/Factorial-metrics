package com.sramiro.factorial.application.port.in;

import com.sramiro.factorial.application.dto.MetricDTO;
import com.sramiro.factorial.application.port.out.MetricRepository;
import com.sramiro.factorial.application.service.MetricUseCaseImpl;
import com.sramiro.factorial.application.service.mapper.MetricMapper;
import com.sramiro.factorial.domain.model.Metric;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@RequiredArgsConstructor
class MetricUseCaseTest {

    public static final String METRIC = "metric";

    @Mock
    private MetricRepository metricRepository;

    @InjectMocks
    private MetricUseCaseImpl metricUseCase;

    @Test
    void CreateMetric_ShouldReturnValidMetricDTO() {
        // Given
        MetricDTO metricDTO = getMetricDTO(METRIC, 10.0, LocalDateTime.now());

        when(metricRepository.save(any(Metric.class))).thenReturn(MetricMapper.dtoToMetric(metricDTO));

        // When
        MetricDTO result = metricUseCase.createMetric(metricDTO);

        // Then
        assertEquals(metricDTO.getTimestamp(), result.getTimestamp());
        assertEquals(metricDTO.getName(), result.getName());
        assertEquals(metricDTO.getValue(), result.getValue());
    }

    @Test
    void CreateMetric_ShouldCreateMetricAndReturnDTO() {
        // Given
        MetricDTO metricDTO = getMetricDTO(METRIC, 5.0, LocalDateTime.now());

        when(metricRepository.save(any(Metric.class))).thenReturn(MetricMapper.dtoToMetric(metricDTO));

        // When
        MetricDTO result = metricUseCase.createMetric(metricDTO);

        // Then
        assertEquals(metricDTO.getTimestamp(), result.getTimestamp());
        assertEquals(metricDTO.getName(), result.getName());
        assertEquals(metricDTO.getValue(), result.getValue());

        verify(metricRepository, times(1)).save(any(Metric.class));

    }

    @Test
    void getMetrics_ShouldReturnListOfDTOs() {
        // Given
        List<Metric> metrics = new ArrayList<>();

        metrics.add(Metric.builder().id(1L).name("metric1").value(10.0).timestamp(LocalDateTime.now()).build());
        metrics.add(Metric.builder().id(2L).name("metric2").value(15.0).timestamp(LocalDateTime.now()).build());

        when(metricRepository.findAll()).thenReturn(metrics);

        // When
        List<MetricDTO> result = metricUseCase.getMetrics();

        // Then
        assertNotNull(result);
        assertEquals(metrics.size(), result.size());
        verify(metricRepository, times(1)).findAll();
    }

    private static MetricDTO getMetricDTO(String name, double value, LocalDateTime timestamp) {
        return MetricDTO.builder()
                .name(name)
                .value(value)
                .timestamp(timestamp)
                .build();
    }
}
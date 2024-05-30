package com.sramiro.factorial.application.port.in;

import com.sramiro.factorial.application.dto.MetricDTO;
import com.sramiro.factorial.application.port.out.MetricRepository;
import com.sramiro.factorial.application.service.MetricService;
import com.sramiro.factorial.domain.model.Metric;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@RequiredArgsConstructor
class MetricUseCaseTest {

    @Mock
    private MetricRepository metricRepository;

    @InjectMocks
    private MetricService metricService;

    @Test
    void saveMetric_ShouldReturnValidMetricDTO() {
        // Given
        MetricDTO metricDTO = new MetricDTO(LocalDateTime.now(), "metric", 10.0);
        Metric savedMetric = Metric.builder()
                .id(1L)
                .timestamp(metricDTO.getTimestamp())
                .name(metricDTO.getName())
                .value(metricDTO.getValue())
                .build();
        when(metricRepository.save(any(Metric.class))).thenReturn(savedMetric);

        // When
        MetricDTO result = metricService.saveMetric(metricDTO);

        // Then
        assertEquals(metricDTO.getTimestamp(), result.getTimestamp());
        assertEquals(metricDTO.getName(), result.getName());
        assertEquals(metricDTO.getValue(), result.getValue());
    }

    @Test
    void saveMetric_ShouldSaveMetricAndReturnDTO() {
        // Given
        MetricDTO metricDTO = new MetricDTO(LocalDateTime.now(), "metric2", 5.0);
        Metric savedMetric = Metric.builder()
                .id(1L)
                .timestamp(metricDTO.getTimestamp())
                .name(metricDTO.getName())
                .value(metricDTO.getValue())
                .build();

        when(metricRepository.save(any(Metric.class))).thenReturn(savedMetric);

        // When
        MetricDTO result = metricService.saveMetric(metricDTO);

        // Then
        assertEquals(metricDTO.getTimestamp(), result.getTimestamp());
        assertEquals(metricDTO.getName(), result.getName());
        assertEquals(metricDTO.getValue(), result.getValue());

        verify(metricRepository, times(1)).save(any(Metric.class));

    }
}

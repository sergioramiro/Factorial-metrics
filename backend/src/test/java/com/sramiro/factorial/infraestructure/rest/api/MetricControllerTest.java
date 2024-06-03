package com.sramiro.factorial.infraestructure.rest.api;

import com.sramiro.factorial.application.dto.MetricDTO;
import com.sramiro.factorial.application.port.in.metrics.CreateMetricUseCase;
import com.sramiro.factorial.application.port.in.metrics.GetAverageMetricsByIntervalUseCase;
import com.sramiro.factorial.domain.enums.Interval;
import com.sramiro.factorial.domain.model.Metric;
import com.sramiro.factorial.infraestructure.rest.api.dto.request.CreateMetricRequest;
import com.sramiro.factorial.infraestructure.rest.api.dto.response.MetricResponse;
import com.sramiro.factorial.infraestructure.rest.api.mapper.MetricControllerMapper;
import com.sramiro.factorial.infraestructure.rest.api.mapper.MetricControllerMapperImpl;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@RequiredArgsConstructor
class MetricControllerTest {
    @Mock
    private CreateMetricUseCase createMetricUseCase;

    @Mock
    private GetAverageMetricsByIntervalUseCase getAverageMetricsByIntervalUseCase;

    @InjectMocks
    private MetricController metricController;

    @Spy
    private MetricControllerMapper mapper = new MetricControllerMapperImpl();


    @Test
    void createPaymentMethod_ShouldReturnValidMetricResponse() {

        // Given
        CreateMetricRequest request = CreateMetricRequest.builder().name("name").value(15.0).build();
        Metric metric = Metric.builder().id(1L).name("name").value(15.0).timestamp(LocalDateTime.now()).build();

        when(createMetricUseCase.createMetric(any(MetricDTO.class))).thenReturn(metric);

        // When
        MetricResponse response = metricController.createPaymentMethod(request);

        // Then
        assertNotNull(response);
        assertEquals(1L, response.getId());
        assertEquals(15.0, response.getValue());
        assertEquals("name", response.getName());
        assertNotNull(response.getTimestamp());
    }

    @Test
    void createPaymentMethod_ShouldCallCreateMetricUseCaseAndReturnValidMetricResponse() {

        // Given
        CreateMetricRequest request = CreateMetricRequest.builder().name("name").value(15.0).build();
        Metric metric = Metric.builder().id(2L).name("name2").value(20.0).timestamp(LocalDateTime.now()).build();

        when(createMetricUseCase.createMetric(any(MetricDTO.class))).thenReturn(metric);

        // When
        MetricResponse response = metricController.createPaymentMethod(request);

        // Then
        assertNotNull(response);
        assertEquals(2L, response.getId());
        assertEquals(20.0, response.getValue());
        assertEquals("name2", response.getName());
        assertNotNull(response.getTimestamp());

        verify(createMetricUseCase, times(1)).createMetric(any(MetricDTO.class));

    }

    @Test
    void getAverageMetricsByInterval_ShouldCallGetAverageMetricsByIntervalUseCaseAndReturnValidListMetricResponse() {
        LocalDateTime time = LocalDateTime.now();
        Metric metric1 = Metric.builder().id(1L).name("name1").value(11.5).timestamp(time).build();
        Metric metric2 = Metric.builder().id(2L).name("name2").value(22.5).timestamp(time.plusMinutes(1L)).build();
        // Given
        List<Metric> listMetrics = List.of(metric1, metric2);
        when(getAverageMetricsByIntervalUseCase.getAverageMetricsByInterval(Interval.DAY)).thenReturn(listMetrics);

        // When
        List<MetricResponse> response = metricController.getAverageMetricsByInterval(Interval.DAY.name());

        // Then
        assertNotNull(response);
        assertEquals(response.size(), 2);
        assertEquals(response.get(0).getId(), 1L);
        assertEquals(response.get(1).getId(), 2L);
        assertEquals(response.get(0).getName(), "name1");
        assertEquals(response.get(1).getName(), "name2");
        assertEquals(response.get(0).getTimestamp(), time);
        assertEquals(response.get(1).getTimestamp(), time.plusMinutes(1L));

        verify(getAverageMetricsByIntervalUseCase).getAverageMetricsByInterval(Interval.DAY);

    }

}
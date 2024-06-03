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
    public static final String NAME_1 = "name1";
    public static final String NAME_2 = "name2";
    public static final String NAME = "name";

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
        CreateMetricRequest request = CreateMetricRequest.builder().name(NAME).value(15.0).build();
        Metric metric = Metric.builder().id(1L).name(NAME).value(15.0).timestamp(LocalDateTime.now()).build();

        when(createMetricUseCase.createMetric(any(MetricDTO.class))).thenReturn(metric);

        // When
        MetricResponse response = metricController.createPaymentMethod(request);

        // Then
        assertNotNull(response);
        assertEquals(1L, response.getId());
        assertEquals(15.0, response.getValue());
        assertEquals(NAME, response.getName());
        assertNotNull(response.getTimestamp());
    }

    @Test
    void createPaymentMethod_ShouldCallCreateMetricUseCaseAndReturnValidMetricResponse() {

        // Given
        CreateMetricRequest request = CreateMetricRequest.builder().name(NAME).value(15.0).build();
        Metric metric = Metric.builder().id(2L).name(NAME_2).value(20.0).timestamp(LocalDateTime.now()).build();

        when(createMetricUseCase.createMetric(any(MetricDTO.class))).thenReturn(metric);

        // When
        MetricResponse response = metricController.createPaymentMethod(request);

        // Then
        assertNotNull(response);
        assertEquals(2L, response.getId());
        assertEquals(20.0, response.getValue());
        assertEquals(NAME_2, response.getName());
        assertNotNull(response.getTimestamp());

        verify(createMetricUseCase, times(1)).createMetric(any(MetricDTO.class));

    }

    @Test
    void getAverageMetricsByInterval_ShouldCallGetAverageMetricsByIntervalUseCaseAndReturnValidListMetricResponse() {
        LocalDateTime time = LocalDateTime.now();
        Metric metric1 = Metric.builder().id(1L).name(NAME_1).value(11.5).timestamp(time).build();
        Metric metric2 = Metric.builder().id(2L).name(NAME_2).value(22.5).timestamp(time.plusMinutes(1L)).build();
        // Given
        List<Metric> listMetrics = List.of(metric1, metric2);
        when(getAverageMetricsByIntervalUseCase.getAverageMetricsByInterval(Interval.DAY)).thenReturn(listMetrics);

        // When
        List<MetricResponse> response = metricController.getAverageMetricsByInterval(Interval.DAY.name());

        // Then
        assertNotNull(response);
        assertEquals(2, response.size());
        assertEquals(1L, response.get(0).getId());
        assertEquals(2L, response.get(1).getId());
        assertEquals(NAME_1, response.get(0).getName());
        assertEquals(NAME_2, response.get(1).getName());
        assertEquals(time, response.get(0).getTimestamp());
        assertEquals(time.plusMinutes(1L), response.get(1).getTimestamp());

        verify(getAverageMetricsByIntervalUseCase).getAverageMetricsByInterval(Interval.DAY);

    }

}
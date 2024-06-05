package com.sramiro.factorial.infraestructure.rest.api;

import com.sramiro.factorial.application.dto.MetricDTO;
import com.sramiro.factorial.application.port.in.metrics.CreateMetricUseCase;
import com.sramiro.factorial.application.port.in.metrics.GetAverageMetricsByIntervalUseCase;
import com.sramiro.factorial.domain.enums.Interval;
import com.sramiro.factorial.domain.model.AverageMetric;
import com.sramiro.factorial.domain.model.Metric;
import com.sramiro.factorial.domain.views.AverageMetricView;
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
import java.util.Map;

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
    public static final String TIME = "time";

    @Mock
    private CreateMetricUseCase createMetricUseCase;

    @Mock
    private GetAverageMetricsByIntervalUseCase getAverageMetricsByIntervalUseCase;

    @InjectMocks
    private MetricController metricController;

    @Spy
    private MetricControllerMapper mapper = new MetricControllerMapperImpl();


    @Test
    void createMetric_ShouldReturnValidMetricResponse() {

        // Given
        CreateMetricRequest request = CreateMetricRequest.builder().name(NAME).value(15.0).build();
        Metric metric = Metric.builder().id(1L).name(NAME).value(15.0).timestamp(LocalDateTime.now()).build();

        when(createMetricUseCase.createMetric(any(MetricDTO.class))).thenReturn(metric);

        // When
        MetricResponse response = metricController.createMetric(request);

        // Then
        assertNotNull(response);
        assertEquals(1L, response.getId());
        assertEquals(15.0, response.getValue());
        assertEquals(NAME, response.getName());
        assertNotNull(response.getTimestamp());
    }

    @Test
    void createMetric_ShouldCallCreateMetricUseCaseAndReturnValidMetricResponse() {

        // Given
        CreateMetricRequest request = CreateMetricRequest.builder().name(NAME).value(15.0).build();
        Metric metric = Metric.builder().id(2L).name(NAME_2).value(20.0).timestamp(LocalDateTime.now()).build();

        when(createMetricUseCase.createMetric(any(MetricDTO.class))).thenReturn(metric);

        // When
        MetricResponse response = metricController.createMetric(request);

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
        AverageMetric metric1 = AverageMetric.builder().name(NAME_1).average(11.5).period(time).build();
        AverageMetric metric2 = AverageMetric.builder().name(NAME_2).average(22.5).period(time.plusMinutes(1L)).build();
        // Given
        List<AverageMetricView> listMetrics = List.of(metric1, metric2);
        when(getAverageMetricsByIntervalUseCase.getAverageMetricsByInterval(Interval.DAY)).thenReturn(listMetrics);

        // When
        List<Map<String, Object>> response = metricController.getAverageMetricsByInterval(Interval.DAY.name());

        // Then
        assertNotNull(response);
        assertEquals(2, response.size());
        assertEquals(11.5, response.get(0).get(NAME_1));
        assertEquals(22.5, response.get(1).get(NAME_2));
        assertNotNull(response.get(0).get(TIME));
        assertNotNull(response.get(0).get(TIME));

        verify(getAverageMetricsByIntervalUseCase).getAverageMetricsByInterval(Interval.DAY);

    }

}
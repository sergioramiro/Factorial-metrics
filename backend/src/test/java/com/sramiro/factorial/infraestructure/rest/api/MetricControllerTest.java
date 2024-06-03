package com.sramiro.factorial.infraestructure.rest.api;

import com.sramiro.factorial.application.dto.MetricDTO;
import com.sramiro.factorial.application.port.in.metrics.CreateMetricUseCase;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@RequiredArgsConstructor
class MetricControllerTest {
    @Mock
    private CreateMetricUseCase createMetricUseCase;

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
}
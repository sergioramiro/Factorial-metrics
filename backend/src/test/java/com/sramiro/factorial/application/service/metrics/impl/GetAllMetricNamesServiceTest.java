package com.sramiro.factorial.application.service.metrics.impl;

import com.sramiro.factorial.application.port.out.MetricRepository;
import com.sramiro.factorial.application.service.mapper.MetricMapper;
import com.sramiro.factorial.application.service.mapper.MetricMapperImpl;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@SpringBootTest
@RequiredArgsConstructor
class GetAllMetricNamesServiceTest {

    @Mock
    private MetricRepository metricRepository;

    @InjectMocks
    private GetAllMetricNamesService service;

    @Spy
    private MetricMapper metricMapper = new MetricMapperImpl();

    @Test
    public void getAllMetricNames_EmptyDatabaseShouldReturnEmptyList() {
        // Given
        when(metricRepository.getAllMetricNames()).thenReturn(new ArrayList<>());

        // When
        List<String> result = service.getAllMetricNames();

        // Then
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }
}
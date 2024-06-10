package com.sramiro.factorial.application.port.in.interactor;

import com.sramiro.factorial.application.port.in.GetAllMetricNamesUseCase;
import com.sramiro.factorial.application.port.out.MetricRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RequiredArgsConstructor
class GetAllMetricNamesImplTest {

    @Mock
    private MetricRepository metricRepository;

    private GetAllMetricNamesUseCase useCase;

    @BeforeEach
    public void init() {
        useCase = new GetAllMetricNamesImpl(metricRepository);
    }

    @Test
    void getAllMetricNames_EmptyDatabaseShouldReturnEmptyList() {
        // Given
        when(metricRepository.getAllMetricNames()).thenReturn(new ArrayList<>());

        // When
        List<String> result = useCase.execute();

        // Then
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    public void getAllMetricNames_SingleMetricNameShouldReturnSingleMetricName() {
        // Given
        when(metricRepository.getAllMetricNames()).thenReturn(List.of("name"));

        // When
        List<String> result = useCase.execute();

        // Then
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("name", result.get(0));
    }

    @Test
    void getAllMetricNames_MultipleMetricNamesShouldReturnMultipleMetricNames() {
        // Given
        when(metricRepository.getAllMetricNames()).thenReturn(List.of("name1", "name2", "name3"));

        // When
        List<String> metricNames = useCase.execute();

        // Then
        assertNotNull(metricNames);
        assertEquals(3, metricNames.size());
        assertTrue(metricNames.contains("name1"));
        assertTrue(metricNames.contains("name2"));
        assertTrue(metricNames.contains("name3"));
    }
}
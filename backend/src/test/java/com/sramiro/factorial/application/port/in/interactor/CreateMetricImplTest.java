package com.sramiro.factorial.application.port.in.interactor;

import com.sramiro.factorial.application.port.in.mapper.CreateMetricUseCaseMapper;
import com.sramiro.factorial.application.port.in.mapper.CreateMetricUseCaseMapperImpl;
import com.sramiro.factorial.application.port.out.MetricRepository;
import com.sramiro.factorial.domain.model.Metric;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RequiredArgsConstructor
class CreateMetricImplTest {
    public static final String METRIC = "metric";

    @Mock
    private MetricRepository metricRepository;

    @InjectMocks
    private CreateMetricImpl useCase;

    @Spy
    private CreateMetricUseCaseMapper mapper = new CreateMetricUseCaseMapperImpl();

    @BeforeEach
    public void init() {
        useCase = new CreateMetricImpl(metricRepository, new CreateMetricUseCaseMapperImpl());
    }

    @Test
    void CreateMetric_ShouldCreateMetricAndReturnDTO() {
        // Given
        Metric metric = Metric.builder().name(METRIC).value(10.0).timestamp(LocalDateTime.now()).build();

        when(metricRepository.save(any(Metric.class))).thenReturn(metric);

        // When
        Metric result = useCase.execute(mapper.toInputValues(metric));

        // Then
        assertEquals(metric.getTimestamp(), result.getTimestamp());
        assertEquals(metric.getName(), result.getName());
        assertEquals(metric.getValue(), result.getValue());

        verify(metricRepository, times(1)).save(any(Metric.class));

    }

}
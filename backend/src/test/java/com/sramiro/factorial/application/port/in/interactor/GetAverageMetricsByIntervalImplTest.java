package com.sramiro.factorial.application.port.in.interactor;

import com.sramiro.factorial.application.port.in.mapper.GetAverageMetricsByIntervalUseCaseMapper;
import com.sramiro.factorial.application.port.in.mapper.GetAverageMetricsByIntervalUseCaseMapperImpl;
import com.sramiro.factorial.application.port.out.MetricRepository;
import com.sramiro.factorial.domain.enums.Interval;
import com.sramiro.factorial.domain.model.AverageMetric;
import com.sramiro.factorial.domain.views.AverageMetricView;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static com.sramiro.factorial.application.port.in.GetAverageMetricsByIntervalUseCase.InputValues;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@RequiredArgsConstructor
class GetAverageMetricsByIntervalImplTest {

    private static final String NAME = "NAME";
    @Mock
    private MetricRepository metricRepository;

    @InjectMocks
    private GetAverageMetricsByIntervalImpl service;

    @Spy
    private GetAverageMetricsByIntervalUseCaseMapper mapper = new GetAverageMetricsByIntervalUseCaseMapperImpl();


    @Test
    void execute_ShouldCallRepositoryAndReturnListOfDTOs() {
        // Given
        LocalDateTime time = LocalDateTime.now();
        AverageMetric metric1 = getAverageMetric("_1", 11.5, time);
        AverageMetric metric2 = getAverageMetric("_2", 22.5, time.plusMinutes(1L));

        List<AverageMetricView> listMetrics = List.of(metric1, metric2);
        when(metricRepository.getAverageMetricsByInterval(Interval.MINUTE.getInterval())).thenReturn(listMetrics);

        // When
        List<AverageMetricView> result = service.execute(InputValues.builder().interval(Interval.MINUTE.getInterval()).build());

        // Then
        assertEquals(2, result.size());
        assertEquals(time, result.get(0).getPeriod());
        assertEquals(NAME + "_1", result.get(0).getName());
        assertEquals(11.5, result.get(0).getAverage());

        assertEquals(time.plusMinutes(1L), result.get(1).getPeriod());
        assertEquals(NAME + "_2", result.get(1).getName());
        assertEquals(22.5, result.get(1).getAverage());

        verify(metricRepository, times(1)).getAverageMetricsByInterval(Interval.MINUTE.getInterval());

    }

    private static AverageMetric getAverageMetric(String _1, double average, LocalDateTime time) {
        return AverageMetric.builder().name(NAME + _1).average(average).period(time).build();
    }

}
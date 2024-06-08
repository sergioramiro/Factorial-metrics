package com.sramiro.factorial.application.port.in.interactor;

import com.sramiro.factorial.application.port.in.GetAverageMetricsByIntervalUseCase;
import com.sramiro.factorial.application.port.out.MetricRepository;
import com.sramiro.factorial.domain.views.AverageMetricView;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAverageMetricsByIntervalImpl implements GetAverageMetricsByIntervalUseCase {

    private final MetricRepository metricRepository;

    @Override
    public List<AverageMetricView> execute(InputValues input) {
        return metricRepository.getAverageMetricsByInterval(input.getInterval());
    }
}
package com.sramiro.factorial.application.port.in.interactor;

import com.sramiro.factorial.application.port.in.CreateMetricUseCase;
import com.sramiro.factorial.application.port.in.mapper.CreateMetricUseCaseMapper;
import com.sramiro.factorial.application.port.out.MetricRepository;
import com.sramiro.factorial.domain.model.Metric;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateMetricImpl implements CreateMetricUseCase {

    private final MetricRepository metricRepository;
    private final CreateMetricUseCaseMapper mapper;

    @Override
    public Metric execute(InputValues input) {
        return metricRepository.save(mapper.toMetric(input));
    }
}
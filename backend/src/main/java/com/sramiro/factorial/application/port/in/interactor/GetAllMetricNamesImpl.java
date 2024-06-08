package com.sramiro.factorial.application.port.in.interactor;

import com.sramiro.factorial.application.port.in.GetAllMetricNamesUseCase;
import com.sramiro.factorial.application.port.out.MetricRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllMetricNamesImpl implements GetAllMetricNamesUseCase {

    private final MetricRepository metricRepository;

    @Override
    public List<String> execute() {
        return metricRepository.getAllMetricNames();
    }
}

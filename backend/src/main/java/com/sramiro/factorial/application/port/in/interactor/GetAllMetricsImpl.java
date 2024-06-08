package com.sramiro.factorial.application.port.in.interactor;

import com.sramiro.factorial.application.port.in.GetAllMetricsUseCase;
import com.sramiro.factorial.application.port.out.MetricRepository;
import com.sramiro.factorial.domain.model.Metric;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllMetricsImpl implements GetAllMetricsUseCase {

    private final MetricRepository metricRepository;

    @Override
    public List<Metric> execute() {
        return metricRepository.findAll();
    }

}
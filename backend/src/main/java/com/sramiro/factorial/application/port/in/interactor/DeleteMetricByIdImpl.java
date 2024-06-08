package com.sramiro.factorial.application.port.in.interactor;

import com.sramiro.factorial.application.port.in.DeleteMetricByIdUseCase;
import com.sramiro.factorial.application.port.out.MetricRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteMetricByIdImpl implements DeleteMetricByIdUseCase {

    private final MetricRepository metricRepository;

    @Override
    public void execute(InputValues input) {
        metricRepository.deleteById(input.getId());
    }
}

package com.sramiro.factorial.application.port.in;

import com.sramiro.factorial.domain.model.Metric;

import java.util.List;

public interface GetAllMetricsUseCase {
    List<Metric> execute();
}

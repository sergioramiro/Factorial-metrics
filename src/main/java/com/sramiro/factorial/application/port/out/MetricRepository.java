package com.sramiro.factorial.application.port.out;

import com.sramiro.factorial.domain.model.Metric;


public interface MetricRepository {
    Metric save(Metric metric);

}

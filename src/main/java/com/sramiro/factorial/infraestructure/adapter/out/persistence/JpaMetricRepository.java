package com.sramiro.factorial.infraestructure.adapter.out.persistence;

import com.sramiro.factorial.application.port.out.MetricRepository;
import com.sramiro.factorial.domain.model.Metric;
import org.springframework.stereotype.Repository;

@Repository
public class JpaMetricRepository implements MetricRepository {
    @Override
    public Metric save(Metric metric) {
        return null;
    }
}

package com.sramiro.factorial.application.port.out;

import com.sramiro.factorial.domain.model.Metric;
import com.sramiro.factorial.domain.views.AverageMetricView;

import java.util.List;

public interface MetricRepository {

    List<String> getAllMetricNames();

    Metric save(Metric metric);

    void deleteById(Long id);

    List<AverageMetricView> getAverageMetricsByInterval(String interval);

    List<Metric> findAll();

    void deleteAll();
}

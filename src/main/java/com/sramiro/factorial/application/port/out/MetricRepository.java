package com.sramiro.factorial.application.port.out;

import com.sramiro.factorial.domain.model.Metric;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MetricRepository extends JpaRepository<Metric, Long> {
//    Metric save(Metric metric);

}

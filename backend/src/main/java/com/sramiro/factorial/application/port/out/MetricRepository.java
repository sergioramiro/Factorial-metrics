package com.sramiro.factorial.application.port.out;

import com.sramiro.factorial.domain.model.Metric;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MetricRepository extends JpaRepository<Metric, Long> {
    // TODO: modify the query with correct one
    @Query("SELECT AVG(m.value) FROM Metric m WHERE m.value = ?1")
    List<Metric> getAverageMetricsByInterval(String interval);
}

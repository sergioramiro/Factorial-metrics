package com.sramiro.factorial.application.port.out;

import com.sramiro.factorial.domain.model.Metric;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MetricRepository extends JpaRepository<Metric, Long> {
    // TODO: modify the query with correct one
    @Query(nativeQuery = true, value = "SELECT DATE_TRUNC(?1, timestamp) AS periodo, AVG(m.value) AS valor_promedio FROM Metric m GROUP BY DATE_TRUNC('minute', timestamp) ORDER BY periodo")
    List<Metric> getAverageMetricsByInterval(String interval);
}

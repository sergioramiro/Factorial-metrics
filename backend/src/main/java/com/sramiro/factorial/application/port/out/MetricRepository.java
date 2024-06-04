package com.sramiro.factorial.application.port.out;

import com.sramiro.factorial.domain.model.Metric;
import com.sramiro.factorial.domain.views.AverageMetricView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MetricRepository extends JpaRepository<Metric, Long> {
    @Query(nativeQuery = true, value = """
                        SELECT COUNT(*)                         AS count,
                               name                             AS name,
                               DATE_TRUNC(:interval, timestamp) AS period,
                               AVG(value)                       AS average
                        FROM metric
                        GROUP BY name, period
                        ORDER BY period
            """)
    List<AverageMetricView> getAverageMetricsByInterval(@Param("interval") String interval);

    @Query("SELECT m.name FROM Metric m GROUP BY m.name")
    List<String> getAllMetricNames();
}

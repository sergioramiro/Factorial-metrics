package com.sramiro.factorial.infraestructure.database.repository;

import com.sramiro.factorial.domain.views.AverageMetricView;
import com.sramiro.factorial.infraestructure.database.entity.MetricDBEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SpringDataMetricRepository extends JpaRepository<MetricDBEntity, Long> {
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

    @Query(nativeQuery = true, value = "SELECT name FROM metric GROUP BY name")
    List<String> getAllMetricNames();
}

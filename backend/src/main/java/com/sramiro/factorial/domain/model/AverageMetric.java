package com.sramiro.factorial.domain.model;

import com.sramiro.factorial.domain.views.AverageMetricView;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
public class AverageMetric implements AverageMetricView {
    private long count;
    private String name;
    private LocalDateTime period;
    private double average;
}

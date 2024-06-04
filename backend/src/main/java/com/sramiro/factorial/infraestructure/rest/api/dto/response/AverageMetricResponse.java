package com.sramiro.factorial.infraestructure.rest.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
public class AverageMetricResponse {
    private long count;
    private String name;
    private LocalDateTime period;
    private double average;
}

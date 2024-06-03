package com.sramiro.factorial.infraestructure.rest.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
public class MetricResponse {
    private Long id;

    private LocalDateTime timestamp;

    private String name;

    private Double value;
}

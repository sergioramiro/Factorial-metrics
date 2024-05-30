package com.sramiro.factorial.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@AllArgsConstructor
@Builder
@Data
public class MetricDTO {
    private final String name;
    private final Double value;
    private final LocalDateTime timestamp;

}

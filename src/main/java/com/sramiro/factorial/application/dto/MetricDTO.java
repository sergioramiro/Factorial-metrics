package com.sramiro.factorial.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class MetricDTO {
    private final LocalDateTime timestamp;
    private final String name;
    private final Double value;

}

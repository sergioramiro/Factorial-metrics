package com.sramiro.factorial.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Metric {
    private Long id;

    private LocalDateTime timestamp;

    private String name;

    private Double value;
}

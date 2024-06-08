package com.sramiro.factorial.application.port.in;

import com.sramiro.factorial.domain.model.Metric;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.With;

import java.time.LocalDateTime;

public interface CreateMetricUseCase {
    Metric execute(InputValues input);

    @Data
    @With
    @Builder
    @AllArgsConstructor
    class InputValues {
        private Long id;
        private final String name;
        private final Double value;
        private final LocalDateTime timestamp;
    }

}

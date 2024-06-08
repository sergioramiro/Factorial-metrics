package com.sramiro.factorial.application.port.in;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.With;

public interface DeleteMetricByIdUseCase {
    void execute(InputValues input);

    @Data
    @With
    @Builder
    @AllArgsConstructor
    class InputValues {
        private final Long id;
    }
}

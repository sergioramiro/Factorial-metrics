package com.sramiro.factorial.application.port.in;

import com.sramiro.factorial.domain.views.AverageMetricView;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.With;

import java.util.List;

public interface GetAverageMetricsByIntervalUseCase {
    List<AverageMetricView> execute(InputValues input);

    @Data
    @With
    @Builder
    @AllArgsConstructor
    class InputValues {
        private final String interval;
    }

}

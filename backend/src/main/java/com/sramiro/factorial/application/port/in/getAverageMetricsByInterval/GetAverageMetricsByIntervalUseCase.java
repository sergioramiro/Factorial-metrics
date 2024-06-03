package com.sramiro.factorial.application.port.in.getAverageMetricsByInterval;

import com.sramiro.factorial.application.dto.MetricDTO;
import com.sramiro.factorial.domain.enums.Interval;

import java.util.List;

public interface GetAverageMetricsByIntervalUseCase {
    List<MetricDTO> getAverageMetricsByInterval(Interval interval);
}

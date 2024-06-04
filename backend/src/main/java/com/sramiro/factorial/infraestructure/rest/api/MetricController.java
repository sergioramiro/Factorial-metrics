package com.sramiro.factorial.infraestructure.rest.api;

import com.sramiro.factorial.application.port.in.metrics.CreateMetricUseCase;
import com.sramiro.factorial.application.port.in.metrics.GetAverageMetricsByIntervalUseCase;
import com.sramiro.factorial.domain.enums.Interval;
import com.sramiro.factorial.domain.model.Metric;
import com.sramiro.factorial.domain.views.AverageMetricView;
import com.sramiro.factorial.infraestructure.rest.api.dto.request.CreateMetricRequest;
import com.sramiro.factorial.infraestructure.rest.api.dto.response.AverageMetricResponse;
import com.sramiro.factorial.infraestructure.rest.api.dto.response.MetricResponse;
import com.sramiro.factorial.infraestructure.rest.api.mapper.MetricControllerMapper;
import com.sramiro.factorial.infraestructure.rest.spec.MetricControllerSpec;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MetricController implements MetricControllerSpec {
    private final CreateMetricUseCase createMetricUseCase;
    private final GetAverageMetricsByIntervalUseCase getAverageMetricsByIntervalUseCase;
    private final MetricControllerMapper mapper;

    @Override
    public MetricResponse createPaymentMethod(CreateMetricRequest request) {
        Metric metric = createMetricUseCase.createMetric(mapper.toCreateMetricRequestDto(request));
        return mapper.toMetricResponse(metric);
    }

    @Override
    public List<AverageMetricResponse> getAverageMetricsByInterval(String interval) {
        List<AverageMetricView> metrics = getAverageMetricsByIntervalUseCase.getAverageMetricsByInterval(Interval.valueOf(interval.toUpperCase()));
        return mapper.toListOfAverageMetricsResponse(metrics);
    }
}

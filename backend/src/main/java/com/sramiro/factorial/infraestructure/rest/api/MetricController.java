package com.sramiro.factorial.infraestructure.rest.api;

import com.sramiro.factorial.application.port.in.metrics.CreateMetricUseCase;
import com.sramiro.factorial.application.port.in.metrics.GetAverageMetricsByIntervalUseCase;
import com.sramiro.factorial.domain.enums.Interval;
import com.sramiro.factorial.domain.model.Metric;
import com.sramiro.factorial.infraestructure.rest.api.dto.request.CreateMetricRequest;
import com.sramiro.factorial.infraestructure.rest.api.dto.response.MetricResponse;
import com.sramiro.factorial.infraestructure.rest.api.mapper.MetricControllerMapper;
import com.sramiro.factorial.infraestructure.rest.spec.MetricControllerSpec;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MetricController implements MetricControllerSpec {
    private CreateMetricUseCase createMetricUseCase;
    private GetAverageMetricsByIntervalUseCase getAverageMetricsByIntervalUseCase;
    private MetricControllerMapper mapper;

    @Override
    public MetricResponse createPaymentMethod(CreateMetricRequest request) {
        Metric metric = createMetricUseCase.createMetric(mapper.toCreateMetricRequestDto(request));
        return mapper.toMetricResponse(metric);
    }

    @Override
    public List<MetricResponse> getAverageMetricsByInterval(String interval) {
        List<Metric> metrics = getAverageMetricsByIntervalUseCase.getAverageMetricsByInterval(Interval.valueOf(interval));
        return mapper.toListOfMetricsResponse(metrics);
    }
}

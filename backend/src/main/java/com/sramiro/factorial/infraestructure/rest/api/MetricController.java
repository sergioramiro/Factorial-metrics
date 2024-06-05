package com.sramiro.factorial.infraestructure.rest.api;

import com.sramiro.factorial.application.port.in.metrics.CreateMetricUseCase;
import com.sramiro.factorial.application.port.in.metrics.GetAllMetricNamesUseCase;
import com.sramiro.factorial.application.port.in.metrics.GetAllMetricsUseCase;
import com.sramiro.factorial.application.port.in.metrics.GetAverageMetricsByIntervalUseCase;
import com.sramiro.factorial.domain.enums.Interval;
import com.sramiro.factorial.domain.model.Metric;
import com.sramiro.factorial.domain.views.AverageMetricView;
import com.sramiro.factorial.infraestructure.rest.api.dto.request.CreateMetricRequest;
import com.sramiro.factorial.infraestructure.rest.api.dto.response.MetricResponse;
import com.sramiro.factorial.infraestructure.rest.api.mapper.MetricControllerMapper;
import com.sramiro.factorial.infraestructure.rest.spec.MetricControllerSpec;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class MetricController implements MetricControllerSpec {
    private final CreateMetricUseCase createMetricUseCase;
    private final GetAverageMetricsByIntervalUseCase getAverageMetricsByIntervalUseCase;
    private final GetAllMetricsUseCase getAllMetricsUseCase;
    private final GetAllMetricNamesUseCase getAllMetricNamesUseCase;
    private final MetricControllerMapper mapper;

    @Override
    public MetricResponse createMetric(CreateMetricRequest request) {
        Metric metric = createMetricUseCase.createMetric(mapper.toCreateMetricRequestDto(request));
        return mapper.toMetricResponse(metric);
    }

    @Override
    public List<MetricResponse> getAllMetrics() {
        List<Metric> allMetrics = getAllMetricsUseCase.getAllMetrics();
        return mapper.toMetricResponse(allMetrics);
    }

    @Override
    public List<Map<String, Object>> getAverageMetricsByInterval(String interval) {
        List<AverageMetricView> metrics = getAverageMetricsByIntervalUseCase.getAverageMetricsByInterval(Interval.valueOf(interval.toUpperCase()));
        return metrics.stream()
                .collect(Collectors.groupingBy(am -> am.getPeriod().format(DateTimeFormatter.ofPattern("MM-dd HH:mm"))))
                .entrySet().stream()
                .map(entry -> {
                    Map<String, Object> map = new LinkedHashMap<>();
                    map.put("time", entry.getKey());
                    entry.getValue().forEach(am -> map.put(am.getName(), am.getAverage()));
                    return map;
                })
                .toList();
    }

    @Override
    public List<String> getAllMetricNames() {
        return getAllMetricNamesUseCase.getAllMetricNames();
    }
}

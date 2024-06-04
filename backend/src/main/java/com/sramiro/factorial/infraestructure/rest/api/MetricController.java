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
    public MetricResponse createMetric(CreateMetricRequest request) {
        Metric metric = createMetricUseCase.createMetric(mapper.toCreateMetricRequestDto(request));
        return mapper.toMetricResponse(metric);
    }

    @Override
    public List<AverageMetricResponse> getAverageMetricsByInterval(String interval) {
        List<AverageMetricView> metrics = getAverageMetricsByIntervalUseCase.getAverageMetricsByInterval(Interval.valueOf(interval.toUpperCase()));
//        metrics.stream()
//                .collect(Collectors.groupingBy(am -> am.getPeriod().format(DateTimeFormatter.ofPattern("MM-dd HH:mm"))))
//                .entrySet().stream()
//                .map(entry -> {
//                    Map<String, Object> map = new LinkedHashMap<>();
//                    map.put("time", entry.getKey());
//                    entry.getValue().forEach(am -> map.put(am.getName(), am.getAverage()));
//                    return map;
//                })
//                .collect(Collectors.toList());
        return mapper.toListOfAverageMetricsResponse(metrics);
    }
}

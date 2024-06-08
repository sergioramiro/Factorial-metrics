package com.sramiro.factorial.infraestructure.rest.api;

import com.sramiro.factorial.application.port.in.CreateMetricUseCase;
import com.sramiro.factorial.application.port.in.DeleteMetricByIdUseCase;
import com.sramiro.factorial.application.port.in.GetAllMetricNamesUseCase;
import com.sramiro.factorial.application.port.in.GetAllMetricsUseCase;
import com.sramiro.factorial.application.port.in.GetAverageMetricsByIntervalUseCase;
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
    private final DeleteMetricByIdUseCase deleteMetricByIdUseCase;
    private final MetricControllerMapper mapper;

    @Override
    public MetricResponse createMetric(CreateMetricRequest request) {
        return mapper.toMetricResponse(createMetricUseCase.execute(mapper.toInputValues(request)));
    }

    @Override
    public List<MetricResponse> getAllMetrics() {
        List<Metric> allMetrics = getAllMetricsUseCase.execute();
        return mapper.toMetricResponse(allMetrics);
    }

    @Override
    public List<Map<String, Object>> getAverageMetricsByInterval(String interval) {
        List<AverageMetricView> metrics = getAverageMetricsByIntervalUseCase.execute(mapper.toInputValues(interval.toUpperCase()));
        return metrics.stream()
                .collect(Collectors.groupingBy(
                        am -> am.getPeriod().format(DateTimeFormatter.ofPattern("dd-MM HH:mm")),
                        LinkedHashMap::new,
                        Collectors.toList()
                )).entrySet().stream()
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
        return getAllMetricNamesUseCase.execute();
    }

    @Override
    public void deleteMetricById(Long id) {
        deleteMetricByIdUseCase.execute(mapper.toInputValues(id));
    }
}

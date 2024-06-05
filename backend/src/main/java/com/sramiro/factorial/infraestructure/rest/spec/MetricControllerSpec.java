package com.sramiro.factorial.infraestructure.rest.spec;

import com.sramiro.factorial.infraestructure.rest.api.dto.request.CreateMetricRequest;
import com.sramiro.factorial.infraestructure.rest.api.dto.response.MetricResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RequestMapping(value = "/metrics")
public interface MetricControllerSpec {

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    MetricResponse createMetric(@Valid @RequestBody CreateMetricRequest createMetricRequest);

    @GetMapping()
    //TODO: move to application.properties
    @CrossOrigin(origins = {"http://localhost:3000", "http://localhost:5173"})
    @ResponseStatus(HttpStatus.OK)
    List<MetricResponse> getAllMetrics();

    @GetMapping("/average")
    @CrossOrigin(origins = {"http://localhost:3000", "http://localhost:5173"})
    @ResponseStatus(HttpStatus.OK)
    List<Map<String, Object>> getAverageMetricsByInterval(
            @RequestParam(value = "interval", required = true)
            @Pattern(regexp = "^(minute|hour|day)$", message = "Interval must be 'minute', 'hour', or 'day'")
            String interval
    );

    @GetMapping("/names")
    //TODO: move to application.properties
    @CrossOrigin(origins = {"http://localhost:3000", "http://localhost:5173"})
    @ResponseStatus(HttpStatus.OK)
    List<String> getAllMetricNames();
}
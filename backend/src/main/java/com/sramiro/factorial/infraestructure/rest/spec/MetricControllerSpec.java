package com.sramiro.factorial.infraestructure.rest.spec;

import com.sramiro.factorial.infraestructure.rest.api.dto.request.CreateMetricRequest;
import com.sramiro.factorial.infraestructure.rest.api.dto.response.AverageMetricResponse;
import com.sramiro.factorial.infraestructure.rest.api.dto.response.MetricResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@RequestMapping(value = "/metrics")
public interface MetricControllerSpec {

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    MetricResponse createPaymentMethod(@Valid @RequestBody CreateMetricRequest createMetricRequest);

    @GetMapping("/average")
    @ResponseStatus(HttpStatus.OK)
    List<AverageMetricResponse> getAverageMetricsByInterval(
            @RequestParam(value = "interval", required = true)
            @Pattern(regexp = "^(minute|hour|day)$", message = "Interval must be 'minute', 'hour', or 'day'")
            String interval
    );

}
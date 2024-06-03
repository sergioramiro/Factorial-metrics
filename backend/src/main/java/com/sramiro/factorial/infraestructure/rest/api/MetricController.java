package com.sramiro.factorial.infraestructure.rest.api;

import com.sramiro.factorial.infraestructure.rest.api.dto.request.CreateMetricRequest;
import com.sramiro.factorial.infraestructure.rest.api.dto.response.MetricResponse;
import com.sramiro.factorial.infraestructure.rest.spec.MetricControllerSpec;

import java.time.LocalDateTime;
import java.util.List;

public class MetricController implements MetricControllerSpec {
    @Override
    public MetricResponse createPaymentMethod(CreateMetricRequest createMetricRequest) {
        return MetricResponse.builder().id(1L).name("name").value(15.0).timestamp(LocalDateTime.now()).build();
    }

    @Override
    public List<MetricResponse> getAverageMetricsByInterval(String interval) {
        return List.of();
    }
}

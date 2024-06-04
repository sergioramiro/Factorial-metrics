package com.sramiro.factorial.infraestructure.rest.api.mapper;

import com.sramiro.factorial.application.dto.MetricDTO;
import com.sramiro.factorial.domain.views.AverageMetricView;
import com.sramiro.factorial.domain.model.Metric;
import com.sramiro.factorial.infraestructure.rest.api.dto.request.CreateMetricRequest;
import com.sramiro.factorial.infraestructure.rest.api.dto.response.AverageMetricResponse;
import com.sramiro.factorial.infraestructure.rest.api.dto.response.MetricResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MetricControllerMapper {
    MetricDTO toCreateMetricRequestDto(CreateMetricRequest request);

    MetricResponse toMetricResponse(Metric metric);

    List<AverageMetricResponse> toListOfAverageMetricsResponse(List<AverageMetricView> metrics);
}

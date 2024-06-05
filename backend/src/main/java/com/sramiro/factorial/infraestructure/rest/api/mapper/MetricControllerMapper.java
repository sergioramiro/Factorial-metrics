package com.sramiro.factorial.infraestructure.rest.api.mapper;

import com.sramiro.factorial.application.dto.MetricDTO;
import com.sramiro.factorial.domain.model.Metric;
import com.sramiro.factorial.infraestructure.rest.api.dto.request.CreateMetricRequest;
import com.sramiro.factorial.infraestructure.rest.api.dto.response.MetricResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MetricControllerMapper {
    MetricDTO toCreateMetricRequestDto(CreateMetricRequest request);

    MetricResponse toMetricResponse(Metric metric);

    List<MetricResponse> toMetricResponse(List<Metric> allMetrics);

}

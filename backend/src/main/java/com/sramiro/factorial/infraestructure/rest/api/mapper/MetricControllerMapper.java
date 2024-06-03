package com.sramiro.factorial.infraestructure.rest.api.mapper;

import com.sramiro.factorial.application.dto.MetricDTO;
import com.sramiro.factorial.domain.model.Metric;
import com.sramiro.factorial.infraestructure.rest.api.dto.request.CreateMetricRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MetricControllerMapper {
    MetricDTO toCreateMetricRequestDto(CreateMetricRequest request);

    Metric toMetric(MetricDTO request);
}

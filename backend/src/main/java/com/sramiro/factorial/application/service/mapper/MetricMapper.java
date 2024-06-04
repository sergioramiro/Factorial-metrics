package com.sramiro.factorial.application.service.mapper;

import com.sramiro.factorial.application.dto.MetricDTO;
import com.sramiro.factorial.domain.model.Metric;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MetricMapper {
    MetricDTO toMetricDto(Metric request);

    Metric toMetric(MetricDTO request);

}

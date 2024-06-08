package com.sramiro.factorial.infraestructure.rest.api.mapper;

import com.sramiro.factorial.application.port.in.CreateMetricUseCase;
import com.sramiro.factorial.application.port.in.DeleteMetricByIdUseCase;
import com.sramiro.factorial.application.port.in.GetAverageMetricsByIntervalUseCase;
import com.sramiro.factorial.domain.model.Metric;
import com.sramiro.factorial.infraestructure.rest.api.dto.request.CreateMetricRequest;
import com.sramiro.factorial.infraestructure.rest.api.dto.response.MetricResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MetricControllerMapper {
    MetricResponse toMetricResponse(Metric metric);

    List<MetricResponse> toMetricResponse(List<Metric> allMetrics);

    CreateMetricUseCase.InputValues toInputValues(CreateMetricRequest request);

    GetAverageMetricsByIntervalUseCase.InputValues toInputValues(String interval);

    DeleteMetricByIdUseCase.InputValues toInputValues(Long id);
}

package com.sramiro.factorial.application.port.in.mapper;

import com.sramiro.factorial.domain.model.Metric;
import org.mapstruct.Mapper;

import static com.sramiro.factorial.application.port.in.CreateMetricUseCase.InputValues;

@Mapper(componentModel = "spring")
public interface CreateMetricUseCaseMapper {
    Metric toMetric(InputValues input);

    InputValues toInputValues(Metric inputValues);
}

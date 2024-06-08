package com.sramiro.factorial.infraestructure.database.mapper;

import com.sramiro.factorial.domain.model.Metric;
import com.sramiro.factorial.infraestructure.database.entity.MetricDBEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DBMetricMapper {
    Metric toDomain(MetricDBEntity metricDBEntity);

    MetricDBEntity toEntity(Metric metric);

    List<Metric> toDomainList(List<MetricDBEntity> listMetricDBEntity);
}

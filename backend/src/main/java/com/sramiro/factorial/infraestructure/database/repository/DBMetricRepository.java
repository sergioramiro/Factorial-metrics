package com.sramiro.factorial.infraestructure.database.repository;

import com.sramiro.factorial.application.port.out.MetricRepository;
import com.sramiro.factorial.domain.model.Metric;
import com.sramiro.factorial.domain.views.AverageMetricView;
import com.sramiro.factorial.infraestructure.database.mapper.DBMetricMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DBMetricRepository implements MetricRepository {
    private final SpringDataMetricRepository repository;
    private final DBMetricMapper mapper;

    @Override
    public List<String> getAllMetricNames() {
        return repository.getAllMetricNames();
    }

    @Override
    public Metric save(Metric metric) {
        return mapper.toDomain(repository.save(mapper.toEntity(metric)));
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<AverageMetricView> getAverageMetricsByInterval(String interval) {
        return repository.getAverageMetricsByInterval(interval);
    }

    @Override
    public List<Metric> findAll() {
        return mapper.toDomainList(repository.findAllByOrderByIdDesc());
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
}

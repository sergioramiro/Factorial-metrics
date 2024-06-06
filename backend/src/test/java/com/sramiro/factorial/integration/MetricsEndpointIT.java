package com.sramiro.factorial.integration;

import com.sramiro.factorial.application.port.out.MetricRepository;
import com.sramiro.factorial.configuration.TestContainerConfiguration;
import com.sramiro.factorial.infraestructure.rest.api.dto.request.CreateMetricRequest;
import io.restassured.RestAssured;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import static io.restassured.RestAssured.given;

class MetricsEndpointIT extends TestContainerConfiguration {
    @Autowired
    private MetricRepository metricRepository;

    @LocalServerPort
    private Integer port;

    @BeforeEach
    void before() {
        RestAssured.port = port;
    }

    @Test
    @SneakyThrows
    void test() {
        long count = metricRepository.count();
        given()
                .contentType("application/json")
                .body(CreateMetricRequest.builder().name("test").value(15.0).build())
                .when()
                .post("/metrics")
                .then()
                .statusCode(HttpStatus.CREATED.value());
        long count2 = metricRepository.count();
        Assertions.assertEquals(count + 1, count2);
    }


}

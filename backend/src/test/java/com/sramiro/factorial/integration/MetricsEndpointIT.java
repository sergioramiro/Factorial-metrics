package com.sramiro.factorial.integration;

import com.sramiro.factorial.application.port.out.MetricRepository;
import com.sramiro.factorial.configuration.TestContainerConfiguration;
import com.sramiro.factorial.domain.model.Metric;
import com.sramiro.factorial.infraestructure.rest.api.dto.request.CreateMetricRequest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MetricsEndpointIT extends TestContainerConfiguration {
    public static final String METRICS = "/metrics";
    public static final String TEST = "test";
    public static final String CONTENT_TYPE = "application/json";
    public static final double VALUE = 15.0;
    @Autowired
    private MetricRepository metricRepository;

    @LocalServerPort
    private Integer port;

    @BeforeEach
    void before() {
        RestAssured.port = port;
        metricRepository.deleteAll();
    }

    @Test
    void postMetricEndpoint_ShouldIncreaseMetricCountInDatabase() {
        long count = metricRepository.count();
        given()
                .contentType(CONTENT_TYPE)
                .body(CreateMetricRequest.builder().name(TEST).value(VALUE).build())
                .when()
                .post(METRICS)
                .then()
                .statusCode(HttpStatus.CREATED.value());
        long count2 = metricRepository.count();
        assertEquals(count + 1, count2);
    }

    @Test
    void getMetricsEndpoint_ShouldReturnTenMetrics() {
        for (int i = 0; i < 10; i++) {
            metricRepository.save(Metric.builder().value(VALUE).name(TEST).build());
        }
        Response response = given()
                .get(METRICS)
                .then()
                .statusCode(HttpStatus.OK.value())
                .extract().response();

        int metricCount = response.jsonPath().getList("$").size();

        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
        assertEquals(10, metricCount);

    }

}

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

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
            saveInRepository(TEST, VALUE);
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

    @Test
    void getAllMetricNamesEndpoint_ShouldReturnAllTheMetricNames() {

        saveInRepository(TEST + "1", VALUE);
        saveInRepository(TEST + "2", VALUE);
        saveInRepository(TEST + "3", VALUE);

        Response response = given()
                .get(METRICS + "/names")
                .then()
                .statusCode(HttpStatus.OK.value())
                .extract().response();

        List<Object> nameList = response.jsonPath().getList("$");
        int NamesCount = nameList.size();

        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
        assertEquals(3, NamesCount);
        assertTrue(nameList.contains(TEST + "1"));
        assertTrue(nameList.contains(TEST + "2"));
        assertTrue(nameList.contains(TEST + "3"));

    }

    private void saveInRepository(String name, double value) {
        metricRepository.save(Metric.builder().value(value).name(name).build());
    }

}

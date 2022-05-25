package org.earelin.alexandria.integration.monitoring;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.Test;

public class HealthCheckTest {

  @Test
  void should_return_status_ok() {
    given()
        .auth()
        .basic("admin", "admin")
    .when()
        .get("/actuator/health")
    .then()
        .statusCode(200)
        .body("status", equalTo("UP"));
  }
}

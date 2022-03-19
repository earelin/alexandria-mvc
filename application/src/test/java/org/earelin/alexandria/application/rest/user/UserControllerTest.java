package org.earelin.alexandria.application.rest.user;

import static org.earelin.alexandria.application.UserGenerator.generateUserPage;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.any;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import java.io.IOException;
import org.earelin.alexandria.domain.user.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(UserController.class)
@AutoConfigureMockMvc(addFilters = false)
class UserControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private UserService userService;

  @BeforeEach
  void setUp() {
    RestAssuredMockMvc.mockMvc(mockMvc);
  }

  @Test
  void should_return_user_paginated_list() throws IOException {
    Mockito.when(userService.getPaginatedList(any()))
        .thenReturn(generateUserPage());

    RestAssuredMockMvc
        .given()
        .when()
          .get("/user")
        .then()
          .statusCode(200)
          .body(
            "number", equalTo(2),
            "size", equalTo(14),
            "total", equalTo(5)
          );
  }

}

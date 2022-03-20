package org.earelin.alexandria.application.rest.user;

import static org.earelin.alexandria.application.UserGenerator.generateUserPage;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.any;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import java.io.IOException;
import java.util.Optional;
import org.earelin.alexandria.domain.user.User;
import org.earelin.alexandria.domain.user.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(UserController.class)
@WithMockUser(username = "john.smith")
class UserControllerComponentTest {

  private static final String USER_EMAIL = "john.smith@example.com";
  private static final String USER_ID = "ca65da03-8691-4b2d-872c-ea26a519fcc3";
  private static final String USER_NAME = "john.smith";
  private static final String USER_PASSWORD
      = "$2a$12$5qlHWkYC3xAJyCJgmqUvxePwv1E5HuUkEyzmI1nhjI.w/CJi1iuoe";

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
            "total", equalTo(5));
  }

  @Test
  void should_return_current_user_information() {
    User user = User.builder()
        .id(USER_ID)
        .name(USER_NAME)
        .email(USER_EMAIL)
        .password(USER_PASSWORD)
        .build();
    Mockito.when(userService.findByName("john.smith"))
        .thenReturn(Optional.of(user));

    RestAssuredMockMvc
        .given()
        .when()
          .get("/user/me")
        .then()
          .statusCode(200)
          .body(
            "id", equalTo(USER_ID),
            "name", equalTo(USER_NAME),
            "email", equalTo(USER_EMAIL));
  }

}

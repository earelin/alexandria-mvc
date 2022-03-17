package org.earelin.alexandria.application.rest;

import static org.assertj.core.api.Assertions.assertThat;

import org.earelin.alexandria.domain.user.User;
import org.junit.jupiter.api.Test;

class UserDaoTest {

  private static final String USER_NAME = "john.smith";
  private static final String USER_ID = "fc1c82e4-2c91-4709-bad9-d9a29ea7df42";
  private static final String USER_EMAIL = "john.smith@example.com";

  @Test
  void should_create_object_from_domain_user() {
    assertThat(UserDto.from(generateUser()))
        .hasFieldOrPropertyWithValue("id", USER_ID)
        .hasFieldOrPropertyWithValue("name", USER_NAME)
        .hasFieldOrPropertyWithValue("email", USER_EMAIL);
  }

  private User generateUser() {
    return User.builder()
        .id(USER_ID)
        .name(USER_NAME)
        .email(USER_EMAIL)
        .build();
  }
}

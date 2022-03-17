package org.earelin.alexandria.application.configuration;

import static org.assertj.core.api.Assertions.assertThat;

import org.earelin.alexandria.domain.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserDetailsWrapperTest {

  private static final String USERNAME = "admin";
  private static final String PASSWORD = "secret";

  private UserDetailsWrapper userDetailsWrapper;

  @BeforeEach
  void setUp() {
    User user = User.builder()
        .name(USERNAME)
        .password(PASSWORD)
        .build();
    userDetailsWrapper = new UserDetailsWrapper(user);
  }

  @Test
  void should_return_username() {
    assertThat(userDetailsWrapper.getUsername())
        .isEqualTo(USERNAME);
  }

  @Test
  void should_return_password() {
    assertThat(userDetailsWrapper.getPassword())
        .isEqualTo(PASSWORD);
  }

  @Test
  void account_should_not_expired() {
    assertThat(userDetailsWrapper.isAccountNonExpired())
        .isTrue();
  }

  @Test
  void account_should_not_be_locked() {
    assertThat(userDetailsWrapper.isAccountNonLocked())
        .isTrue();
  }

  @Test
  void credentials_should_not_be_expired() {
    assertThat(userDetailsWrapper.isCredentialsNonExpired())
        .isTrue();
  }

  @Test
  void account_should_be_enabled() {
    assertThat(userDetailsWrapper.isEnabled())
        .isTrue();
  }
}

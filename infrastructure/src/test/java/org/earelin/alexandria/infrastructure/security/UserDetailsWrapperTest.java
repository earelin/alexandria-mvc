package org.earelin.alexandria.infrastructure.security;

import static org.assertj.core.api.Assertions.assertThat;

import org.earelin.alexandria.domain.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserDetailsWrapperTest {

  private static final String USERNAME = "admin";
  private static final String PASSWORD = "secret";

  private User user;

  private UserDetailsWrapper userDetailsWrapper;

  @BeforeEach
  void setUp() {
    user = User.builder()
        .name(USERNAME)
        .password(PASSWORD)
        .build();
    userDetailsWrapper = new UserDetailsWrapper(user);
  }

  @Test
  void should_return_user() {
    assertThat(userDetailsWrapper.user())
        .isEqualTo(user);
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

  @Test
  void should_return_empty_authorities() {
    assertThat(userDetailsWrapper.getAuthorities())
        .isEmpty();
  }
}

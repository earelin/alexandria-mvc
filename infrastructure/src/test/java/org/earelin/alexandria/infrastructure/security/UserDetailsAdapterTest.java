package org.earelin.alexandria.infrastructure.security;

import static org.assertj.core.api.Assertions.assertThat;

import org.earelin.alexandria.domain.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.userdetails.UserDetails;

class UserDetailsAdapterTest {

  private static final String USERNAME = "admin";
  private static final String PASSWORD = "secret";

  private UserDetails userDetailsAdapter;

  @BeforeEach
  void setUp() {
    User user = User.builder()
        .name(USERNAME)
        .password(PASSWORD)
        .build();
    userDetailsAdapter = new UserDetailsAdapter(user);
  }

  @Test
  void should_return_username() {
    assertThat(userDetailsAdapter.getUsername())
        .isEqualTo(USERNAME);
  }

  @Test
  void should_return_password() {
    assertThat(userDetailsAdapter.getPassword())
        .isEqualTo(PASSWORD);
  }

  @Test
  void account_should_not_expired() {
    assertThat(userDetailsAdapter.isAccountNonExpired())
        .isTrue();
  }

  @Test
  void account_should_not_be_locked() {
    assertThat(userDetailsAdapter.isAccountNonLocked())
        .isTrue();
  }

  @Test
  void credentials_should_not_be_expired() {
    assertThat(userDetailsAdapter.isCredentialsNonExpired())
        .isTrue();
  }

  @Test
  void account_should_be_enabled() {
    assertThat(userDetailsAdapter.isEnabled())
        .isTrue();
  }

  @Test
  void should_return_empty_authorities() {
    assertThat(userDetailsAdapter.getAuthorities())
        .isEmpty();
  }
}

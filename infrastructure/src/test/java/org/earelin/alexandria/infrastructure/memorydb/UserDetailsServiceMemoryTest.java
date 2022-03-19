package org.earelin.alexandria.infrastructure.memorydb;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

import java.util.Optional;
import org.earelin.alexandria.domain.user.User;
import org.earelin.alexandria.domain.user.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@ExtendWith(MockitoExtension.class)
class UserDetailsServiceMemoryTest {

  private static final String USERNAME = "john.smith";

  @Mock
  private UserRepository userRepository;

  @Mock
  private UserDetails userDetails;

  private UserDetailsService userDetailsService;

  @BeforeEach
  void setUp() {
    userDetailsService = new UserDetailsServiceMemory(userRepository);
  }

  @Test
  void should_load_a_user_by_name() {
    when(userRepository.findByName(USERNAME))
        .thenReturn(Optional.of(generateUser()));

    assertThat(userDetailsService.loadUserByUsername(USERNAME))
        .hasFieldOrPropertyWithValue("username", USERNAME);
  }

  @Test
  void should_throw_username_not_found_exception() {
    when(userRepository.findByName(USERNAME))
        .thenReturn(Optional.empty());

    assertThatThrownBy(() -> userDetailsService.loadUserByUsername(USERNAME))
        .isInstanceOf(UsernameNotFoundException.class);
  }

  private User generateUser() {
    return User.builder()
        .name(USERNAME)
        .build();
  }

}

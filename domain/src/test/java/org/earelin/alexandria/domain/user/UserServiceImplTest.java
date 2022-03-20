package org.earelin.alexandria.domain.user;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.earelin.alexandria.domain.Page;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

  public static final String USERNAME = "john.smith";

  @Mock
  private UserRepository userRepository;

  @Mock
  private List<User> userList;

  private UserService userService;

  @BeforeEach
  void setUp() {
    userService = new UserServiceImpl(userRepository);
  }

  @Test
  void should_return_paginated_user_list() throws IOException {
    Page<User> userPage = new Page<User>(userList, 2, 14, 5);
    when(userRepository.findAllPaginated(2, 14))
        .thenReturn(userPage);
    UserListRequest userListRequest = new UserListRequest(2, 14);

    Page<User> users = userService.getPaginatedList(userListRequest);

    assertThat(users)
        .isEqualTo(userPage);
  }

  @Test
  void should_return_user_by_name_if_exists() {
    User user = User.builder()
        .name(USERNAME)
        .build();
    when(userRepository.findByName(USERNAME))
        .thenReturn(Optional.of(user));

    assertThat(userService.findByName(USERNAME))
        .isPresent()
        .get()
        .hasFieldOrPropertyWithValue("name", USERNAME);
  }

  @Test
  void should_return_empty_if_there_is_no_user_with_name() {
    when(userRepository.findByName(USERNAME))
        .thenReturn(Optional.empty());

    assertThat(userService.findByName(USERNAME))
        .isNotPresent();
  }

}

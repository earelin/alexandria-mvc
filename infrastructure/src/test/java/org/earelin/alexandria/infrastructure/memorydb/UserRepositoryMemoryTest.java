package org.earelin.alexandria.infrastructure.memorydb;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import org.earelin.alexandria.domain.Page;
import org.earelin.alexandria.domain.user.User;
import org.earelin.alexandria.domain.user.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserRepositoryMemoryTest {

  private UserRepository userRepository;

  @BeforeEach
  void setUp() throws IOException {
    userRepository = new UserRepositoryMemory();
  }

  @Test
  void should_find_a_user_by_name() {
    assertThat(userRepository.findByName("neil.andrews"))
        .isPresent()
        .get()
        .hasFieldOrPropertyWithValue("name", "neil.andrews");
  }

  @Test
  void should_return_empty_if_there_is_no_user_with_searched_name() {
    assertThat(userRepository.findByName("no.user"))
        .isNotPresent();
  }

  @Test
  void should_find_a_user_by_id() {
    assertThat(userRepository.findById("6a79e64a-e0c8-407e-ab7b-8b1f113a7ab1"))
        .isPresent()
        .get()
        .hasFieldOrPropertyWithValue("id", "6a79e64a-e0c8-407e-ab7b-8b1f113a7ab1");
  }

  @Test
  void should_return_empty_if_there_is_no_user_with_searched_id() {
    assertThat(userRepository.findById("no.user"))
        .isNotPresent();
  }

  @Test
  void should_return_paginated_users() {
    Page<User> users = userRepository.findAllPaginated(2, 5);
    assertThat(users)
        .hasFieldOrPropertyWithValue("number", 2)
        .hasFieldOrPropertyWithValue("total", 3)
        .hasFieldOrPropertyWithValue("size", 5);
    assertThat(users.content())
        .hasSize(5)
        .extracting("name")
        .containsExactly(
            "ian.collins", "kelly.weaver", "luke.hall", "marjorie.brown", "martin.fowler");
  }

  @Test
  void should_return_paginated_users_last_page() {
    Page<User> users = userRepository.findAllPaginated(3, 5);
    assertThat(users)
        .hasFieldOrPropertyWithValue("number", 3)
        .hasFieldOrPropertyWithValue("total", 3)
        .hasFieldOrPropertyWithValue("size", 5);
    assertThat(users.content())
        .hasSize(4)
        .extracting("name")
        .containsExactly("neil.andrews", "nicole.young", "roger.allen", "willie.mitchelle");
  }

  @Test
  void should_return_paginated_users_first_page() {
    Page<User> users = userRepository.findAllPaginated(1, 5);
    assertThat(users)
        .hasFieldOrPropertyWithValue("number", 1)
        .hasFieldOrPropertyWithValue("total", 3)
        .hasFieldOrPropertyWithValue("size", 5);
    assertThat(users.content())
        .hasSize(5)
        .extracting("name")
        .contains("admin", "charlotte.hudson", "darrell.ford", "enrique.caldwell", "fred.bailey");
  }

}

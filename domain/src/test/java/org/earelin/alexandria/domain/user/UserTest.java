package org.earelin.alexandria.domain.user;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserTest {

  private static final String USER_1_ID = "41bdefcc-0250-4722-b4e3-a27068c307e0";
  private static final String USER_1_EMAIL = "dan.kennedy@example.com";
  private static final String USER_1_NAME = "dan.kennedy";
  private static final String USER_2_ID = "b236e034-ac8a-4d01-9d2f-e0c191df2866";
  private static final String USER_2_EMAIL = "samantha.james@example.com";
  private static final String USER_2_NAME = "samantha.james";

  private User user;

  @BeforeEach
  void setUp() {
    user = generateUser(USER_1_ID, USER_1_EMAIL, USER_1_NAME);
  }

  @Test
  void should_be_equal_to_another_user_with_same_id() {
    var compare = generateUser(USER_1_ID, USER_2_EMAIL, USER_2_NAME);

    assertThat(compare)
        .isEqualTo(user);
  }

  @Test
  void should_not_be_equal_to_another_user_with_different_id() {
    var compare = generateUser(USER_2_ID, USER_1_EMAIL, USER_1_NAME);

    assertThat(compare)
        .isNotEqualTo(user);
  }

  @Test
  void should_have_the_same_hash_code_than_another_user_with_same_id() {
    var compare = generateUser(USER_1_ID, USER_2_EMAIL, USER_2_NAME);

    assertThat(compare)
        .hasSameHashCodeAs(user);
  }

  @Test
  void should_not_have_the_same_hash_code_than_another_user_with_different_id() {
    var compare = generateUser(USER_2_ID, USER_1_EMAIL, USER_1_NAME);

    assertThat(compare)
        .doesNotHaveSameHashCodeAs(user);
  }

  private User generateUser(String id, String email, String name) {
    return User.builder()
        .id(id)
        .email(email)
        .name(name)
        .build();
  }

}

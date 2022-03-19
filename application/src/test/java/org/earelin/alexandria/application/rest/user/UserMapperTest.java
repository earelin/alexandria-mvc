package org.earelin.alexandria.application.rest.user;

import static org.assertj.core.api.Assertions.assertThat;
import static org.earelin.alexandria.application.UserGenerator.generateUserPage;

import java.io.IOException;
import org.earelin.alexandria.domain.Page;
import org.earelin.alexandria.domain.user.User;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

class UserMapperTest {

  private static final String USER_ID = "8fcc9701-cc48-42dc-8e8d-25d776f25477";
  private static final String USER_EMAIL = "kory.mcdermott@email.com";
  private static final String USER_NAME = "kory.mcdermott";
  private static final String USER_PASSWORD = "$2a$12$di8lcRz0/s/DpNe/UD8VZes8iQKkgDzzf93vE2Ai8U14coJvA5qT2";

  private final UserMapper mapper = Mappers.getMapper(UserMapper.class);

  @Test
  void should_convert_domain_user_to_dto() {
    User user = new User(USER_ID, USER_EMAIL, USER_NAME, USER_PASSWORD);

    assertThat(mapper.domainToDto(user))
        .hasFieldOrPropertyWithValue("id", USER_ID)
        .hasFieldOrPropertyWithValue("email", USER_EMAIL)
        .hasFieldOrPropertyWithValue("name", USER_NAME);
  }

  @Test
  void should_convert_domain_users_page_to_dto() throws IOException {
    Page<UserDto> pagedUsers = mapper.paginatedDomainToDto(generateUserPage());

    assertThat(pagedUsers)
        .hasFieldOrPropertyWithValue("number", 2)
        .hasFieldOrPropertyWithValue("size", 14)
        .hasFieldOrPropertyWithValue("total", 5);
    assertThat(pagedUsers.content())
        .hasSize(14);
  }

}

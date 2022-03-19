package org.earelin.alexandria.application;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;
import org.earelin.alexandria.domain.Page;
import org.earelin.alexandria.domain.user.User;
import org.earelin.alexandria.infrastructure.memorydb.UserDao;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

public final class UserGenerator {

  public static Page<User> generateUserPage() throws IOException {
    InputStream inputStream = UserGenerator.class
        .getClassLoader()
        .getResourceAsStream("data/users.json");
    ObjectMapper mapper = Jackson2ObjectMapperBuilder.json().build();
    List<User> users = mapper.readValue(inputStream, new TypeReference<List<UserDao>>() {})
        .stream()
        .map(UserDao::toDomain)
        .collect(Collectors.toList());
    return new Page<>(users, 2, 14, 5);
  }

  private UserGenerator() {}

}

package org.earelin.alexandria.infrastructure.memorydb;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.earelin.alexandria.domain.user.User;
import org.earelin.alexandria.domain.user.UserRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.stereotype.Repository;

@Repository
@Profile("dev")
public class UserRepositoryMemory implements UserRepository {

  private final Map<String, User> users = new HashMap<>();

  public UserRepositoryMemory() throws IOException {
    addDefaultUsers();
  }

  public void addUser(User user) {
    users.put(user.getId(), user);
  }

  @Override
  public Optional<User> findById(String name) {
    return Optional.empty();
  }

  @Override
  public Optional<User> findByName(String name) {
    return users.values()
        .stream()
        .filter(user -> user.getName().equals(name))
        .findFirst();
  }

  @Override
  public Page<User> findAllPaginated(int page, int size) {
    return null;
  }

  private void addDefaultUsers() throws IOException {
    ClassLoader classLoader = getClass().getClassLoader();
    InputStream inputStream = classLoader.getResourceAsStream("data/users.json");
    ObjectMapper mapper = Jackson2ObjectMapperBuilder.json().build();
    mapper.readValue(inputStream, new TypeReference<List<UserDao>>(){})
        .stream()
        .map(UserDao::toDomain)
        .forEach(this::addUser);
  }

}

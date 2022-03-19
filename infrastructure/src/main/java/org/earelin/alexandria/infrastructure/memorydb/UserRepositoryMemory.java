package org.earelin.alexandria.infrastructure.memorydb;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.earelin.alexandria.domain.Page;
import org.earelin.alexandria.domain.user.User;
import org.earelin.alexandria.domain.user.UserRepository;
import org.springframework.context.annotation.Profile;
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
    List<User> usersList = users.values()
        .stream()
        .sorted(Comparator.comparing(User::getName))
        .skip((long) (page - 1) * size)
        .limit(size)
        .toList();

    int totalPages = totalNumberOfPages(size, users.size());

    return new Page<>(usersList, page, size, totalPages);
  }

  private int totalNumberOfPages(int pageSize, int totalItems) {
    return (int) Math.ceil((float) totalItems / pageSize);
  }

  private void addDefaultUsers() throws IOException {
    InputStream inputStream = getClass()
        .getClassLoader()
        .getResourceAsStream("data/users.json");

    ObjectMapper mapper = Jackson2ObjectMapperBuilder.json().build();

    mapper.readValue(inputStream, new TypeReference<List<UserDao>>(){})
        .stream()
        .map(UserDao::toDomain)
        .forEach(this::addUser);
  }

}

package org.earelin.alexandria.infrastructure.memorydb;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.earelin.alexandria.domain.user.User;
import org.earelin.alexandria.domain.user.UserRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

@Repository
@Profile("dev")
public class UserRepositoryMemory implements UserRepository {

  private final Map<String, User> users = new HashMap<>();

  public UserRepositoryMemory() {
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

  private void addDefaultUsers() {
    User admin = User.builder()
        .id("c5b19b36-81a4-41d0-9f0f-4cd10a964e23")
        .name("admin")
        .password("$2a$10$Rs.m3zPWNBZfGSSQzZmlmeB7lLhQWQ0naQKwR1k0qv8iwlR0F9aR2")
        .build();
    addUser(admin);
  }

}

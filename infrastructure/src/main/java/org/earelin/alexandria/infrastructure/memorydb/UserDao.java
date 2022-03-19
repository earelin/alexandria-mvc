package org.earelin.alexandria.infrastructure.memorydb;

import org.earelin.alexandria.domain.user.User;

public record UserDao(String id, String name, String email, String password) {

  public User toDomain() {
    return User.builder()
        .id(id)
        .name(name)
        .email(email)
        .password(password)
        .build();
  }

}

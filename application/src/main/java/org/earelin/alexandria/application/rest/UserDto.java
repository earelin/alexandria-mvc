package org.earelin.alexandria.application.rest;

import org.earelin.alexandria.domain.user.User;

public record UserDto(
    String id,
    String name,
    String email
) {
  public static UserDto from(User user) {
    return new UserDto(
        user.getId(),
        user.getName(),
        user.getEmail()
    );
  }
}

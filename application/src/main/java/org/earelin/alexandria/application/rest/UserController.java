package org.earelin.alexandria.application.rest;

import org.earelin.alexandria.application.rest.pagination.PageDto;
import org.earelin.alexandria.domain.user.UserService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  public PageDto<UserDto> list() {
    throw new UnsupportedOperationException();
  }

}

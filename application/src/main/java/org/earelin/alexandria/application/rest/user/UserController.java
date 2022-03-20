package org.earelin.alexandria.application.rest.user;

import java.security.Principal;
import org.earelin.alexandria.domain.Page;
import org.earelin.alexandria.domain.user.User;
import org.earelin.alexandria.domain.user.UserListRequest;
import org.earelin.alexandria.domain.user.UserService;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

  private final UserService userService;
  private final UserMapper mapper;

  public UserController(UserService userService) {
    this.userService = userService;
    mapper = Mappers.getMapper(UserMapper.class);
  }

  @GetMapping
  public Page<UserDto> list(
      @RequestParam(defaultValue = "1") int page,
      @RequestParam(defaultValue = "14") int size) {
    UserListRequest request = new UserListRequest(page, size);

    Page<User> domainPage = userService.getPaginatedList(request);

    return mapper.paginatedDomainToDto(domainPage);
  }

  @GetMapping("/me")
  public ResponseEntity<UserDto> currentUser(Principal principal) {
    return userService.findByName(principal.getName())
        .map(UserDto::from)
        .map(user -> new ResponseEntity<>(user, HttpStatus.OK))
        .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

}

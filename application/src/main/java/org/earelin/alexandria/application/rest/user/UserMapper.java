package org.earelin.alexandria.application.rest.user;

import org.earelin.alexandria.domain.Page;
import org.earelin.alexandria.domain.user.User;
import org.mapstruct.Mapper;

@Mapper
interface UserMapper {

  UserDto domainToDto(User user);

  Page<UserDto> paginatedDomainToDto(Page<User> users);

}

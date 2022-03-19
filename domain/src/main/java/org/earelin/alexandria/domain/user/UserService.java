package org.earelin.alexandria.domain.user;

import java.util.Optional;
import org.earelin.alexandria.domain.Page;

public interface UserService {

  User register(RegistrationRequest request);

  Optional<User> findById(String id);

  Page<User> getPaginatedList(UserListRequest request);

}

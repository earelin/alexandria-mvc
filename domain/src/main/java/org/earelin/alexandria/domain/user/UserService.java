package org.earelin.alexandria.domain.user;

import java.util.Optional;

public interface UserService {

  User register(RegistrationRequest request);

  Optional<User> findById(String id);

}

package org.earelin.alexandria.domain.user;

import java.util.Optional;

public interface UserRepository {

  Optional<User> findByName(String name);

}

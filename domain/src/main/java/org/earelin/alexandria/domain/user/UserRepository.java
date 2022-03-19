package org.earelin.alexandria.domain.user;

import java.util.Optional;
import org.earelin.alexandria.domain.Page;

public interface UserRepository {

  Optional<User> findById(String name);

  Optional<User> findByName(String name);

  Page<User> findAllPaginated(int page, int size);

}

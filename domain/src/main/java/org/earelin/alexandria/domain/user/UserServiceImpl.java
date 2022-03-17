package org.earelin.alexandria.domain.user;

import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Override
  public User register(RegistrationRequest request) {
    return null;
  }

  @Override
  public Optional<User> findById(String id) {
    return Optional.empty();
  }

}

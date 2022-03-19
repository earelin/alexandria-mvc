package org.earelin.alexandria.domain.user;

import java.util.Optional;
import org.earelin.alexandria.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  private final UserRepository repository;

  public UserServiceImpl(UserRepository repository) {
    this.repository = repository;
  }

  @Override
  public User register(RegistrationRequest request) {
    throw new UnsupportedOperationException();
  }

  @Override
  public Optional<User> findById(String id) {
    return Optional.empty();
  }

  @Override
  public Page<User> getPaginatedList(UserListRequest request) {
      return repository.findAllPaginated(request.page(), request.size());
  }

}

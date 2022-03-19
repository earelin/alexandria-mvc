package org.earelin.alexandria.infrastructure.memorydb;

import lombok.extern.slf4j.Slf4j;
import org.earelin.alexandria.domain.user.UserRepository;
import org.earelin.alexandria.infrastructure.security.UserDetailsWrapper;
import org.springframework.context.annotation.Profile;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Profile("dev")
@Slf4j
public class UserDetailsServiceMemory implements UserDetailsService {

  private final UserRepository userRepository;

  public UserDetailsServiceMemory(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    log.debug("Loading user: {}", username);
    return userRepository.findByName(username)
        .map(UserDetailsWrapper::new)
        .orElseThrow(() -> new UsernameNotFoundException(username));
  }

}

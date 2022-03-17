package org.earelin.alexandria.application.configuration;

import lombok.extern.slf4j.Slf4j;
import org.earelin.alexandria.domain.user.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
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
        .orElse(null);
  }

}

package org.earelin.alexandria.domain.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
public class User {
  @EqualsAndHashCode.Include
  String id;
  String email;
  String name;
  String password;
}

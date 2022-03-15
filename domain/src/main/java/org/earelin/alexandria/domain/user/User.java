package org.earelin.alexandria.domain.user;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class User {
  String id;
  String name;
  String password;
}

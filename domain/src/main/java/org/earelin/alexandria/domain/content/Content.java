package org.earelin.alexandria.domain.content;

import java.util.List;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;
import org.earelin.alexandria.domain.components.Component;

@Builder
@Value
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Content {

  @EqualsAndHashCode.Include
  String id;

  String title;

  List<Component> components;

  Status status;

}

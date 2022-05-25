package org.earelin.alexandria.domain.content;

import java.util.Optional;
import org.earelin.alexandria.domain.Page;

public interface ContentRepository {

  Optional<Content> findById(String id);

  void saveOrUpdate(Content content);

  void removeById(String id);

  Page<Content> findAllPaginated(int page, int size);

}

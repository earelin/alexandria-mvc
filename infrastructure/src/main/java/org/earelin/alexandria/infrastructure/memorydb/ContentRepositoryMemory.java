package org.earelin.alexandria.infrastructure.memorydb;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.earelin.alexandria.domain.Page;
import org.earelin.alexandria.domain.content.Content;
import org.earelin.alexandria.domain.content.ContentRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
@Profile("dev")
public class ContentRepositoryMemory implements ContentRepository {

  private final Map<String, Content> contentMap = new HashMap<>();

  @Override
  public Optional<Content> findById(String id) {
    return Optional.ofNullable(contentMap.get(id));
  }

  @Override
  public void saveOrUpdate(Content content) {
    contentMap.put(content.getId(), content);
  }

  @Override
  public void removeById(String id) {
    contentMap.remove(id);
  }

  @Override
  public Page<Content> findAllPaginated(int page, int size) {
    return null;
  }

}

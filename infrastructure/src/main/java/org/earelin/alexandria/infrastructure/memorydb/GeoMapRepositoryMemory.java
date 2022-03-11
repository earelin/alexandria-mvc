package org.earelin.alexandria.infrastructure.memorydb;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.earelin.alexandria.domain.GeoMap;
import org.earelin.alexandria.domain.GeoMapRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

@Repository
public class GeoMapRepositoryMemory implements GeoMapRepository {

  private final Map<String, GeoMap> maps = new HashMap<>();

  @Override
  public Optional<GeoMap> findById(String id) {
    return Optional.ofNullable(maps.get(id));
  }

  @Override
  public void saveOrUpdate(GeoMap geoMap) {
    maps.put(geoMap.getId(), geoMap);
  }

  @Override
  public void removeById(String id) {
    maps.remove(id);
  }

  @Override
  public Page<GeoMap> findAllPaginated(PageRequest pageRequest) {
    return null;
  }

}

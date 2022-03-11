package org.earelin.alexandria.domain;

import java.util.Optional;
import org.springframework.data.domain.Page;

public interface GeoMapRepository {

  Optional<GeoMap> findById(String id);

  void saveOrUpdate(GeoMap geoMap);

  void removeById(String id);

  Page<GeoMap> findAllPaginated(int page, int size);

}

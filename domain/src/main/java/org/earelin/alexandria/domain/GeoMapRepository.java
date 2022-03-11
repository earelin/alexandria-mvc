package org.earelin.alexandria.domain;

import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface GeoMapRepository {

  Optional<GeoMap> findById(String id);

  void saveOrUpdate(GeoMap geoMap);

  void removeById(String id);

  Page<GeoMap> findAllPaginated(PageRequest pageRequest);

}

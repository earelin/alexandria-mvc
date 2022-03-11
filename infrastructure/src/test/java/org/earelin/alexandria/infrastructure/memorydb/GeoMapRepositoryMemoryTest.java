package org.earelin.alexandria.infrastructure.memorydb;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.earelin.alexandria.domain.GeoMap;
import org.earelin.alexandria.domain.GeoMapRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class GeoMapRepositoryMemoryTest {

  private static final String GEO_MAP_ID = "2de4cc10-7a39-4610-b52d-febfebcdc78b";
  private static final GeoMap GEO_MAP = new GeoMap(GEO_MAP_ID, "European Map");

  private GeoMapRepository geoMapRepository;

  @BeforeEach
  void setUp() {
    geoMapRepository = new GeoMapRepositoryMemory();
  }

  @Test
  void should_save_and_return_a_geomap() {
    geoMapRepository.saveOrUpdate(GEO_MAP);

    assertThat(geoMapRepository.findById(GEO_MAP_ID))
        .isPresent()
        .get()
        .isEqualTo(GEO_MAP);
  }
}

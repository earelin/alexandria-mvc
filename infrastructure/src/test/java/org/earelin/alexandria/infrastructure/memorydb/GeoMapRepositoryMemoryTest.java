package org.earelin.alexandria.infrastructure.memorydb;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import org.earelin.alexandria.domain.GeoMap;
import org.earelin.alexandria.domain.content.Content;
import org.earelin.alexandria.domain.content.ContentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class GeoMapRepositoryMemoryTest {

  private static final String CONTENT_ID = "2de4cc10-7a39-4610-b52d-febfebcdc78b";
  private static final Content CONTENT = Content.builder()
      .id(CONTENT_ID)
      .title("European Map")
      .build();

  private ContentRepository geoMapRepository;

  @BeforeEach
  void setUp() {
    geoMapRepository = new GeoMapRepositoryMemory();
  }

  @Test
  void should_save_and_return_a_geomap() {
    geoMapRepository.saveOrUpdate(CONTENT);

    assertThat(geoMapRepository.findById(CONTENT_ID))
        .isPresent()
        .get()
        .isEqualTo(CONTENT);
  }
}

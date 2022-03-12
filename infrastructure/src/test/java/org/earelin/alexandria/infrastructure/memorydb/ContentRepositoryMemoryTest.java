package org.earelin.alexandria.infrastructure.memorydb;

import static org.assertj.core.api.Assertions.assertThat;

import org.earelin.alexandria.domain.content.Content;
import org.earelin.alexandria.domain.content.ContentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ContentRepositoryMemoryTest {

  private static final String CONTENT_ID = "2de4cc10-7a39-4610-b52d-febfebcdc78b";
  private static final Content CONTENT = Content.builder()
      .id(CONTENT_ID)
      .title("European Map")
      .build();

  private ContentRepository contentRepository;

  @BeforeEach
  void setUp() {
    contentRepository = new ContentRepositoryMemory();
  }

  @Test
  void should_save_and_return_a_geomap() {
    contentRepository.saveOrUpdate(CONTENT);

    assertThat(contentRepository.findById(CONTENT_ID))
        .isPresent()
        .get()
        .isEqualTo(CONTENT);
  }
}

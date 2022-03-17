package org.earelin.alexandria.application.rest.pagination;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;

@ExtendWith(MockitoExtension.class)
class PageDtoTest {

  private static final int TOTAL_PAGES = 12;
  private static final int PAGE_NUMBER = 2;
  private static final int PAGE_SIZE = 20;
  private static final List<String> PAGE_CONTENT
      = List.of("one", "two", "three", "four");

  @Test
  void should_construct_object_from_spring_page() {
    Page<String> springPage = mock(Page.class);
    when(springPage.getTotalPages())
        .thenReturn(TOTAL_PAGES);
    when(springPage.getNumber())
        .thenReturn(PAGE_NUMBER);
    when(springPage.getSize())
        .thenReturn(PAGE_SIZE);
    when(springPage.getContent())
        .thenReturn(PAGE_CONTENT);

    PageDto<String> page = PageDto.fromPage(springPage);

    assertThat(page)
        .hasFieldOrPropertyWithValue("number", PAGE_NUMBER)
        .hasFieldOrPropertyWithValue("size", PAGE_SIZE)
        .hasFieldOrPropertyWithValue("total", TOTAL_PAGES)
        .hasFieldOrPropertyWithValue("content", PAGE_CONTENT);
  }

}

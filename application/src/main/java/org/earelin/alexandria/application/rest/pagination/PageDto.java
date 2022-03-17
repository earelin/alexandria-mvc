package org.earelin.alexandria.application.rest.pagination;

import java.util.List;
import org.springframework.data.domain.Page;

public record PageDto<T>(
    List<T> content,
    int number,
    int size,
    int total
) {

  public static <T> PageDto<T> fromPage(Page<T> pages) {
    return new PageDto<>(
        pages.getContent(),
        pages.getNumber(),
        pages.getSize(),
        pages.getTotalPages()
    );
  }

}

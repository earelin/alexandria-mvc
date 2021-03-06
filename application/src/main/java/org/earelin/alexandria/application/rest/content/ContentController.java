package org.earelin.alexandria.application.rest.content;

import org.earelin.alexandria.domain.content.ContentService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContentController {

  private final ContentService contentService;

  public ContentController(ContentService contentService) {
    this.contentService = contentService;
  }

}

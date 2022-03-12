package org.earelin.alexandria.application.rest;

import org.earelin.alexandria.domain.content.ContentService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContentController {

  private final ContentService geoMapService;

  public ContentController(ContentService geoMapService) {
    this.geoMapService = geoMapService;
  }



}

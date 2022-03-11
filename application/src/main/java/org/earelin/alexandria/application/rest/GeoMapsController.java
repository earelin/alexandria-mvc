package org.earelin.alexandria.application.rest;

import org.earelin.alexandria.domain.GeoMapService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GeoMapsController {

  private final GeoMapService geoMapService;

  public GeoMapsController(GeoMapService geoMapService) {
    this.geoMapService = geoMapService;
  }



}

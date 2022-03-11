package org.earelin.alexandria.application.rest;

import org.earelin.alexandria.domain.GeoMapRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MapsController {

  private final GeoMapRepository mapRepository;

  public MapsController(GeoMapRepository mapRepository) {
    this.mapRepository = mapRepository;
  }

}

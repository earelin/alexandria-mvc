package org.earelin.alexandria.application.rest;

import org.earelin.alexandria.domain.MapRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MapsController {

  private final MapRepository mapRepository;

  public MapsController(MapRepository mapRepository) {
    this.mapRepository = mapRepository;
  }



}

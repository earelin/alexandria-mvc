package org.earelin.alexandria.application;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AlexandriaApplicationTest {

  @Test
  void contextLoads() {
    assertThat(true)
        .isTrue();
  }

}

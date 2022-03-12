package org.earelin.alexandria.domain.content;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContentTest {

  private static final String CONTENT_1_ID = "f42a1c1b-352f-4cad-b9bc-d29600a0b3e2";
  private static final String CONTENT_1_TITLE = "Lorem ipsum dolor sit amet";
  private static final String CONTENT_2_ID = "3707d2bd-80ce-40c5-aca5-6894cb186e0b";
  private static final String CONTENT_2_TITLE = "Vivamus eget dolor velit";

  private Content content;

  @BeforeEach
  void setUp() {
    content = generateContent(CONTENT_1_ID, CONTENT_1_TITLE);
  }

  @Test
  void content_with_same_id_is_equal() {
    Content compare = generateContent(CONTENT_1_ID, CONTENT_2_TITLE);

    assertThat(compare)
        .isEqualTo(content);
  }

  @Test
  void content_with_different_id_is_not_equal() {
    Content compare = generateContent(CONTENT_2_ID, CONTENT_2_TITLE);

    assertThat(compare)
        .isNotEqualTo(content);
  }

  @Test
  void content_with_same_id_have_same_hashcode() {
    Content compare = generateContent(CONTENT_1_ID, CONTENT_2_TITLE);

    assertThat(compare)
        .hasSameHashCodeAs(content);
  }

  @Test
  void content_with_different_id_does_not_have_same_hashcode() {
    Content compare = generateContent(CONTENT_2_ID, CONTENT_2_TITLE);

    assertThat(compare)
        .doesNotHaveSameHashCodeAs(content);
  }

  private Content generateContent(String id, String title) {
    return Content.builder()
        .id(id)
        .title(title)
        .status(Status.DRAFT)
        .build();
  }

}

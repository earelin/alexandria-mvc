package org.earelin.alexandria.domain;

import java.util.List;

public record Page<T>(
    List<T> content,
    int number,
    int size,
    int total) {
}

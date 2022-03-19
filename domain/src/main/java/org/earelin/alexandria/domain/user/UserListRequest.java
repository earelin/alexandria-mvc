package org.earelin.alexandria.domain.user;

public record UserListRequest(
    int page,
    int size
) {}

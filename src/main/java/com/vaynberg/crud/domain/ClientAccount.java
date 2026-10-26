package com.vaynberg.crud.domain;

import java.time.OffsetDateTime;

public record ClientAccount(
        Long id,
        String fullName,
        String gender,
        AccountStatus status,
        OffsetDateTime createdAt,
        OffsetDateTime modifyAt
) {}
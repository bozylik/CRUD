package com.vaynberg.crud.dto;

import com.vaynberg.crud.domain.AccountStatus;

import java.time.OffsetDateTime;

public record ClientAccountResponse(
        Long id,
        String fullName,
        String gender,
        AccountStatus status,
        OffsetDateTime createdAt,
        OffsetDateTime modifyAt
) {

}

package com.vaynberg.crud.exception;

import java.time.OffsetDateTime;

public record ErrorResponseDto(
        String message,
        String detailedMessage,
        OffsetDateTime errorTime
) {
}

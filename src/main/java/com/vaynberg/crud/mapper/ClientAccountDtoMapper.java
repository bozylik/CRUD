package com.vaynberg.crud.mapper;

import com.vaynberg.crud.domain.AccountStatus;
import com.vaynberg.crud.domain.ClientAccount;
import com.vaynberg.crud.dto.ClientAccountRequest;
import com.vaynberg.crud.dto.ClientAccountResponse;
import com.vaynberg.crud.dto.ClientAccountUpdateRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClientAccountDtoMapper {

    // Для POST (создание): статус по умолчанию всегда ACTIVE
    public ClientAccount toDomain(ClientAccountRequest request) {
        return new ClientAccount(
                null,
                request.fullName(),
                request.gender(),
                AccountStatus.ACTIVE,
                null,
                null
        );
    }

    // Для PUT (обновление): статус берется из ClientAccountUpdateRequest
    public ClientAccount toDomain(ClientAccountUpdateRequest request) {
        return new ClientAccount(
                null,
                request.fullName(),
                request.gender(),
                request.status(),
                null,
                null
        );
    }

    public ClientAccountResponse toResponse(ClientAccount domain) {
        return new ClientAccountResponse(
                domain.id(),
                domain.fullName(),
                domain.gender(),
                domain.status(),
                domain.createdAt(),
                domain.modifyAt()
        );
    }

    public List<ClientAccountResponse> toResponseList(List<ClientAccount> domainList) {
        return domainList.stream()
                .map(this::toResponse)
                .toList();
    }
}
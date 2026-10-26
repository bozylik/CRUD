package com.vaynberg.crud.mapper;

import com.vaynberg.crud.domain.ClientAccount;
import com.vaynberg.crud.model.ClientAccountEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClientAccountEntityMapper {
    public ClientAccountEntity toEntity(ClientAccount domain) {
        return new ClientAccountEntity(
                domain.id(),
                domain.fullName(),
                domain.gender(),
                domain.status()
        );
    }

    public ClientAccount toDomain(ClientAccountEntity entity) {
        return new ClientAccount(
                entity.getId(),
                entity.getFullName(),
                entity.getGender(),
                entity.getStatus(),
                entity.getCreatedAt(),
                entity.getModifyAt()
        );
    }

    public List<ClientAccount> toDomainList(List<ClientAccountEntity> entities) {
        return entities.stream()
                .map(this::toDomain)
                .toList();
    }

}

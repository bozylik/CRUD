package com.vaynberg.crud.service;

import com.vaynberg.crud.domain.ClientAccount;
import com.vaynberg.crud.mapper.ClientAccountEntityMapper;
import com.vaynberg.crud.repository.ClientAccountRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClientAccountService {
    private final ClientAccountRepository clientRepository;
    private final ClientAccountEntityMapper clientEntityMapper;

    public ClientAccountService(ClientAccountRepository clientRepository,
                                ClientAccountEntityMapper clientEntityMapper) {
        this.clientRepository = clientRepository;
        this.clientEntityMapper = clientEntityMapper;
    }

    @Transactional
    public ClientAccount create(ClientAccount domain) {
        var entityToCreate = clientEntityMapper.toEntity(domain);

        var createdEntity = clientRepository.save(entityToCreate);

        return clientEntityMapper.toDomain(createdEntity);
    }


    public List<ClientAccount> findAll() {
        return clientEntityMapper.toDomainList(clientRepository.findAll());
    }

    public ClientAccount findById(Long id) {
        return clientRepository.findById(id)
                .map(clientEntityMapper::toDomain)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Client account with id " + id + " not found"
                ));
    }

    @Transactional
    public ClientAccount updateById(Long id, ClientAccount domain) {
        var entityToUpdate = clientRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(
                "Client account with id " + id + " not found"
        ));

        entityToUpdate.setFullName(domain.fullName());
        entityToUpdate.setGender(domain.gender());
        entityToUpdate.setStatus(domain.status());

        clientRepository.saveAndFlush(entityToUpdate);
        return clientEntityMapper.toDomain(entityToUpdate);
    }

    @Transactional
    public void deleteById(Long id) {
        if (!clientRepository.existsById(id)) {
            throw new EntityNotFoundException("Client account with id " + id + " not found");
        }

        clientRepository.deleteById(id);
    }
}

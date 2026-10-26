package com.vaynberg.crud.controller;

import com.vaynberg.crud.dto.ClientAccountRequest;
import com.vaynberg.crud.dto.ClientAccountResponse;
import com.vaynberg.crud.dto.ClientAccountUpdateRequest;
import com.vaynberg.crud.mapper.ClientAccountDtoMapper;
import com.vaynberg.crud.service.ClientAccountService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {
    private final ClientAccountService clientService;
    private final ClientAccountDtoMapper clientDtoMapper;

    public ClientController(ClientAccountService clientService, ClientAccountDtoMapper clientDtoMapper) {
        this.clientService = clientService;
        this.clientDtoMapper = clientDtoMapper;
    }

    @PostMapping
    public ResponseEntity<ClientAccountResponse> createClientAccount(
            @Valid @RequestBody ClientAccountRequest request) {

        var domainToCreate = clientDtoMapper.toDomain(request);
        var createdDomain = clientService.create(domainToCreate);
        var response = clientDtoMapper.toResponse(createdDomain);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<ClientAccountResponse>> getAllClientAccounts() {

        return ResponseEntity.ok()
                .body(clientDtoMapper.toResponseList(clientService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientAccountResponse> getClientAccountById(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok()
                .body(clientDtoMapper.toResponse(clientService.findById(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientAccountResponse> updateClientAccount(
            @PathVariable Long id,
            @Valid @RequestBody ClientAccountUpdateRequest request
    ) {
        var domainToUpdate = clientDtoMapper.toDomain(request);

        var updatedDomain = clientService.updateById(id, domainToUpdate);

        var response = clientDtoMapper.toResponse(updatedDomain);

        return ResponseEntity.ok().body(response);
    }   

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClientAccount(@PathVariable Long id) {
        clientService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}

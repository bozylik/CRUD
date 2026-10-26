package com.vaynberg.crud.repository;

import com.vaynberg.crud.model.ClientAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientAccountRepository extends JpaRepository<ClientAccountEntity, Long> {

}

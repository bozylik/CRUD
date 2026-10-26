package com.vaynberg.crud.model;

import com.vaynberg.crud.domain.AccountStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.OffsetDateTime;

@Entity
@Table(name="client_account")
public class ClientAccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="full_name", nullable = false)
    private String fullName;

    @Column(name="gender", length = 1)
    private String gender;

    @Enumerated(EnumType.STRING)
    @Column(name="status", length=20)
    private AccountStatus status;

    @CreationTimestamp
    @Column(name = "created_dttm", nullable = false, updatable = false)
    private OffsetDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "modify_dttm", nullable = false)
    private OffsetDateTime modifyAt;

    public ClientAccountEntity() {}

    public ClientAccountEntity(
            Long id,
            String fullName,
            String gender,
            AccountStatus status
    ) {
        this.id = id;
        this.fullName = fullName;
        this.gender = gender;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public OffsetDateTime getModifyAt() {
        return modifyAt;
    }
}

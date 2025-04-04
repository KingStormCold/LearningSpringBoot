package com.store_phone.entities;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@MappedSuperclass
public class BaseEntity {

    @Column(name = "created_date")
    @CreatedDate
    protected LocalDateTime createdDate;

    @Column(name = "created_by")
    @CreatedBy
    protected String createdBy;

    @Column(name = "updated_date")
    @LastModifiedDate
    protected LocalDateTime updatedDate;

    @Column(name = "updated_by")
    @LastModifiedBy
    protected String updatedBy;

    @PrePersist
    void createdDate() {
        this.createdDate = this.updatedDate = LocalDateTime.now();
    }

    @PreUpdate
    void updateDate() {
        this.updatedDate = LocalDateTime.now();
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
}

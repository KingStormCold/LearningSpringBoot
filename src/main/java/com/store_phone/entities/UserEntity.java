package com.store_phone.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table (name = "users")
public class UserEntity extends BaseEntity {

    @Id
    @Column (name = "user_name")
    private String userName;

    @Column (name = "full_name")
    private String fullName;

    @Column (name = "active")
    private boolean active;

    @Column (name = "email")
    private String email;

    @Column (name = "phone_number")
    private String phoneNumber;

    @Column (name = "password")
    private String password;

    @Column (name = "address")
    private String address;

    public Set<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleEntity> roles) {
        this.roles = roles;
    }

    public Set<ProductEntity> getProducts() {
        return products;
    }

    public void setProducts(Set<ProductEntity> products) {
        this.products = products;
    }

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "users",cascade = CascadeType.ALL)
    private Set<RoleEntity> roles;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
    private Set<ProductEntity> products;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

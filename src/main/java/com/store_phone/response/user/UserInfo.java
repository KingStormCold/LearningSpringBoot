package com.store_phone.response.user;

import com.store_phone.dtos.RoleDTO;
import com.store_phone.dtos.UserDTO;
import com.store_phone.response.role.RoleInfo;

import java.util.List;
import java.util.Set;

public class UserInfo {
    private String userName;
    private String fullName;
    private String email;
    private String phoneNumber;
    private String address;
    private boolean active;
    private List<RoleInfo> roles;

    public List<RoleInfo> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleInfo> roles) {
        this.roles = roles;
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public UserInfo(UserDTO dto) {
        this.userName = dto.getUserName();
        this.fullName = dto.getFullName();
        this.email = dto.getEmail();
        this.address = dto.getAddress();
        this.phoneNumber = dto.getPhoneNumber();
        this.active = dto.isActive();
        this.roles = dto.getRoles().stream().map(role -> new RoleInfo(role)).toList();
    }
}

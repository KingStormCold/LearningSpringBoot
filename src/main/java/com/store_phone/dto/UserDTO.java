package com.store_phone.dto;

import java.util.Set;

public class UserDTO extends BaseDTO {
	
	private String userName;

    private String password;

    private String fullName;

    private String email;

    private String phoneNumber;

    private String address;

    private boolean active;

    private Set<RoleDTO> roles;
    
    private Set<ProductDTO> products;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public Set<RoleDTO> getRoles() {
		return roles;
	}

	public void setRoles(Set<RoleDTO> roles) {
		this.roles = roles;
	}

	public Set<ProductDTO> getProducts() {
		return products;
	}

	public void setProducts(Set<ProductDTO> products) {
		this.products = products;
	}
	
	@Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserDTO)) {
            return false;
        }
        UserDTO ts = (UserDTO) obj;
        if (this.getUserName() != null && this.getUserName().equals(ts.getUserName())) {
            return true;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
    	if (this.getUserName() == null) {
    		return 31;
    	}
    	return this.getUserName().hashCode();
    }
    
}

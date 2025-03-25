package com.store_phone.dto;

import java.util.Set;

public class RoleDTO {
	
	private String roleId;

    private String roleName;

    private String roleDescription;

    private Set<UserDTO> users;

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDescription() {
		return roleDescription;
	}

	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}

	public Set<UserDTO> getUsers() {
		return users;
	}

	public void setUsers(Set<UserDTO> users) {
		this.users = users;
	}
	
	@Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RoleDTO)) {
            return false;
        }
        RoleDTO ts = (RoleDTO) obj;
        if (this.getRoleId().equals(ts.getRoleId())) {
            return true;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
    	if (this.getRoleId() == null) {
    		return 31;
    	}
    	return this.getRoleId().hashCode();
    }

}

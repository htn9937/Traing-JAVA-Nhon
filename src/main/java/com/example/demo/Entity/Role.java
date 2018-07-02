package com.example.demo.Entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "role", //
        uniqueConstraints = { //
                @UniqueConstraint(name = "uk_role", columnNames = { "role_name" }) })
public class Role {
	
	@Id
    @GeneratedValue
    @Column(name = "role_id", nullable = false)
    private UUID role_id;
 
    @Column(name = "role_name", length = 50, nullable = false)
    private String role_name;

	public UUID getRoleId() {
		return role_id;
	}

	public void setRoleId(UUID roleId) {
		this.role_id = roleId;
	}

	public String getRoleName() {
		return role_name;
	}

	public void setRoleName(String roleName) {
		this.role_name = roleName;
	}
 
}

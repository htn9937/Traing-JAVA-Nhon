package com.example.demo.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "user_role", //
        uniqueConstraints = { //
                @UniqueConstraint(name = "uk_user_role", columnNames = { "user_id", "role_id" }) })
public class UserRole {
	
	@Id
    @GeneratedValue
    @Column(name = "user_role_id", nullable = false)
    private UUID user_role_id;
 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

	public UUID getIduser_role_id() {
		return user_role_id;
	}

	public void setIduser_role_id(UUID iduser_role_id) {
		this.user_role_id = iduser_role_id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}

package com.example.demo.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "user",//
uniqueConstraints = { //
                @UniqueConstraint(name = "uk_user", columnNames = "user_name") })
public class User {
	@Id
  @GeneratedValue
    @Column(name = "user_id", nullable = false)
    private UUID user_id;
 
    @Column(name = "user_name", length = 36, nullable = false)
    private String user_name;
 
    @Column(name = "password", length = 128, nullable = false)
    private String password;
 
    @Column(name = "enabled", length = 1, nullable = false)
    private boolean enabled;

	public UUID getUserId() {
		return user_id;
	}

	public void setUserId(UUID userId) {
		this.user_id = userId;
	}

	public String getUserName() {
		return user_name;
	}

	public void setUserName(String userName) {
		this.user_name = userName;
	}

	public String getEncrytedPassword() {
		return password;
	}

	public void setEncrytedPassword(String encrytedPassword) {
		this.password = encrytedPassword;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
}

package com.cg.fms.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="User_entry1")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	@Column(name="Username")
	private String userName;
	@Column(name="Password")
	private String password;
	private String role;
	
	public User(){
		// no argument constructor
	}
	
	public User(int userId) {
		super();
		this.userId = userId;
	}
	

	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public User(int userId, String userName, String password) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
	}

	public User(String userName, String pwd, String role) {
		super();
		this.userName = userName;
		this.password = pwd;
		this.role = role;
	}

	public User(int userId, String userName, String pwd, String role) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = pwd;
		this.role = role;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPwd(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", pwd=" + password + ", role=" + role + "]";
	}
	
}

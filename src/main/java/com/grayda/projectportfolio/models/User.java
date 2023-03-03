package com.grayda.projectportfolio.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
@Table(name="user_tbl")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message="Username is required")
	@Size(min=3, max=30, message="Username must be 3-30 characters")
	private String username;
	
	@NotEmpty(message="Email is required")
	@Email(message="Email must be valid")
	private String email;
	
	@NotEmpty(message="Password is required")
	@Size(min=8, max=120, message="Password must be 8-120 characters")
	private String password;
	
	@Transient
	@NotEmpty(message="Confirm Password is required")
	@Size(min=8, max=120, message="Confirm Password must be 8-120 characters")
	private String confirm;
	
//========== THIS LINK TO USER - ITEMS ( 1:M ) ===================
	@OneToMany(mappedBy="user", fetch = FetchType.LAZY)
    private List<Item> items;	
	
//========== THIS LINK TO USER - EMPLOYEES ( 1:M ) ===================
	@OneToMany(mappedBy="user", fetch = FetchType.LAZY)
    private List<Employee> employees;	

	public User() {}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
}

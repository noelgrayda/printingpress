package com.grayda.projectportfolio.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="employee_tbl")
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message="Designation is required")
	@Size(min=3, max=30, message="Designation must be 3-30 characters")
	private String designation;
	
	@NotEmpty(message="Employee Name is required")
	@Size(min=3, max=30, message="Employee Name must be 3-30 characters")
	private String employee;
	
	@NotEmpty(message="Work Name is required")
	@Size(min=3, max=30, message="Work Name must be 3-30 characters")
	private String workName;
	
	@NotEmpty(message="Work Status is required")
	private String workStatus;
	
//========== THIS LINK TO USER - EMPLOYEES ( M:1 ) ===================
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;		
	

	
	public Employee() {}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getDesignation() {
		return designation;
	}



	public void setDesignation(String designation) {
		this.designation = designation;
	}



	public String getEmployee() {
		return employee;
	}



	public void setEmployee(String employee) {
		this.employee = employee;
	}



	public String getWorkName() {
		return workName;
	}



	public void setWorkName(String workName) {
		this.workName = workName;
	}



	public String getWorkStatus() {
		return workStatus;
	}



	public void setWorkStatus(String workStatus) {
		this.workStatus = workStatus;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}	



}

package com.cogentautomation.model;

import java.io.Serializable;
import java.time.LocalDate;

import com.cogentautomation.model.enumerator.Role;
import com.cogentautomation.model.shared.ContactInfo;

public class Person extends ContactInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String jobRole = null;
	private Role role = null;
	private LocalDate date = null;
	public Role getRole() {
		return role;
	}
	public void setRole(Role r) {
		role = r;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate localDate) {
		date = localDate;
	}
	public String getJobRole() {
		return jobRole;
	}
	public void setJobRole(String jobRole) {
		this.jobRole = jobRole;
	}
	public String toString() {
		return role.toString();
	}
}

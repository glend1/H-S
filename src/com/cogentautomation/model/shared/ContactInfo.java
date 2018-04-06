package com.cogentautomation.model.shared;

import java.io.Serializable;

public class ContactInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name = null;
	private String address1 = null;
	private String address2 = null;
	private String town = null;
	private String county = null;
	private String postCode = null;
	private String phone = null;
	private String eMail = null;
	public String getName() {
		return name;
	}
	public void setName(String n) {
		name = n;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String a) {
		address1 = a;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String a) {
		address2 = a;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String t) {
		town = t;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String c) {
		county = c;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String pc) {
		postCode = pc;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String p) {
		phone = p;
	}
	public String getEMail() {
		return eMail;
	}
	public void setEMail(String em) {
		eMail = em;
	}
}

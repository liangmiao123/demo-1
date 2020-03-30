package com.newer.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "tb_customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cust_id")
	private Integer custId;
	
	@Column(name = "cust_name")
	private String custName;
	
	private String phone;
	private String mobile;
	private String email;
	private String fax;
	private String address;
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	public Customer(Integer custId, String custName, String phone, String mobile, String email, String fax,
			String address) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.phone = phone;
		this.mobile = mobile;
		this.email = email;
		this.fax = fax;
		this.address = address;
	}
	public Integer getCustId() {
		return custId;
	}
	public void setCustId(Integer custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}

package com.ewiz.sprinbootexcel.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Entity
public class Customer {
	
	@Id
	private String first_name;
	
	private String last_name;
//	
//	@NotNull(message = "Mandatory")
//	@Size(min=10, max=10,message="Length should be 10")
	@Column(name="pan_number")
	private String pannumber;
	
//	@NotNull(message = "Mandatory")
//	@Size(min=12, max=12, message="Length should be 12")
	@Column(name="aadhar_number")
	private long aadharnumber;
	
	@Column(name="uan_number")
	private long uannumber;
	
//	@NotNull(message = "Mandatory")
//	@Email(message = "Email should be valid")
	private String email;
	
//	@NotNull(message = "Mandatory")
//	@Size(min=10, message="Length should be atleast 10 digit")
	private long mobile;
	
	private String address;
	
	private boolean status;
	
	public Customer() {
		super();
		
	}

	

	public Customer(String first_name, String last_name, String pan_number, long aadhar_number,
			long uan_number, String email, long mobile, String address, boolean status) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.pannumber = pan_number;
		this.aadharnumber = aadhar_number;
		this.uannumber = uan_number;
		this.email = email;
		this.mobile = mobile;
		this.address = address;
		this.status = status;
	}



	public String getFirst_name() {
		return first_name;
	}



	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}



	public String getLast_name() {
		return last_name;
	}



	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}



	public String getPannumber() {
		return pannumber;
	}



	public void setPannumber(String pannumber) {
		this.pannumber = pannumber;
	}



	public long getAadharnumber() {
		return aadharnumber;
	}



	public void setAadharnumber(long aadharnumber) {
		this.aadharnumber = aadharnumber;
	}



	public long getUannumber() {
		return uannumber;
	}



	public void setUannumber(long uannumber) {
		this.uannumber = uannumber;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public long getMobile() {
		return mobile;
	}



	public void setMobile(long mobile) {
		this.mobile = mobile;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public boolean isStatus() {
		return status;
	}



	public void setStatus(boolean status) {
		this.status = status;
	}
	
}

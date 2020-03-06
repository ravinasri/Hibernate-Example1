package com.hibernate.model;

import javax.persistence.Embeddable;

@Embeddable
public class Numbers
{
	private String telephone;
	private String personal;
	private String office;
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getPersonal() {
		return personal;
	}
	public void setPersonal(String personal) {
		this.personal = personal;
	}
	public String getOffice() {
		return office;
	}
	public void setOffice(String office) {
		this.office = office;
	}
	public Numbers(String telephone, String personal, String office) {
		super();
		this.telephone = telephone;
		this.personal = personal;
		this.office = office;
	}
	public Numbers() {
		super();
	}
	
	
}
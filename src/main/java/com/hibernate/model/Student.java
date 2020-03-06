package com.hibernate.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="student")
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	@Transient
	@Lob
	private String description;
	
	@Temporal(TemporalType.DATE)
	private Date date_today;
	
	
	@Embedded
	@AttributeOverrides(value = { 
			@AttributeOverride(name="street_name",column = @Column(name = "Office_Street_Name")),
			@AttributeOverride(name="state",column = @Column(name = "Office_State")),
			@AttributeOverride(name="pincode",column = @Column(name = "Office_Pin_Code")),
	})
	private Address Home_address;
	
	@Embedded
	private Address Office_address;
	
	@Embedded
	@ElementCollection
	@JoinTable(name="Stud_num",joinColumns=@JoinColumn(name="Id"))
	private Set<Numbers> numbers=new HashSet<Numbers>();
	
	public long getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDate_today() {
		return date_today;
	}
	public void setDate_today(Date date_today) {
		this.date_today = date_today;
	}
	
	public Address getHome_address() {
		return Home_address;
	}
	public void setHome_address(Address home_address) {
		Home_address = home_address;
	}
	public Address getOffice_address() {
		return Office_address;
	}
	public void setOffice_address(Address office_address) {
		Office_address = office_address;
	}
	
	public Set<Numbers> getNumbers() {
		return numbers;
	}
	public void setNumbers(Set<Numbers> numbers) {
		this.numbers = numbers;
	}
	
	public Student(int id, String firstName, String lastName, String email, String description, Date date_today,
			Address Home_address,Address Office_address) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.description = description;
		this.date_today = date_today;
		this.Home_address = Home_address;
		this.Office_address = Office_address;
	}
	public Student() {
		super();
	}
	
}






//Annotation Definition
//@Entity-mapping entity class into table
//@Id-set primary key
//@Table(name="")-change the table name only not entity class name
//@Entity(name="")-change the name in both table and entity class
//@Column(name="")-changing name of column
//@Lob-marked field as large object eg.clob,blob
//@Temporal(TemporalType.DATE or Time)-i get either date or time by using this
//@Transient-ignoring the column name which means column wont considered at the time of running
//@GeneratedValue(strategy=GenerationType.AUTO)-Id autoincrement
//@Embedded-field level,@Embeddable-class level:cal from one class to another class like Address-street,state or Embedded object
//@AttributeOverrides-if i refer same address model but i will change the column name by using this
//@ElementCollection-we told hibernate it is consider as list at that tome only it will create new table of list.
//@JoinTable(name="")-if create list table,if we want to change the name by using this 
//@JoinColumn-if change the list table column name primary key field by using this.

//hibernate.cfg.xml definition
//dialect             -we tells hibernate which language is this.
//show-sql="true"     -print out all sql statements in console at the time of runnning
//hbm2ddl.auto-create -recreate the database schema which mnt delete exist one again create new one
//hbm2ddl.auto-update -create new one at the same time it have exist one without deleting anything
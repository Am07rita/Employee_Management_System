package com.ems.entity;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Getter

public class Employee extends User {
	@Column(length  =30,nullable=false)
private String empName;
	@Column(length  =30,nullable=false)
private String empAddress;
	@Column(length  =20,nullable=false)
private double salary;
	@Column(length  =10,nullable=false)
private String contact;
	@Column(length  =50,nullable=false,unique = true)
private String email;
	@Column(length  =30,nullable=false)
private String Designation;
	@Column(nullable=false)
private LocalDate DOJ;
@ManyToOne(fetch = FetchType.LAZY)
private Department dept;
@ManyToOne(fetch = FetchType.LAZY)
private Manager manager;
@Builder
public Employee(String empName, String empAddress, double salary, String contact, String email, String designation,
		LocalDate dOJ) {
	super();
	this.empName = empName;
	this.empAddress = empAddress;
	this.salary = salary;
	this.contact = contact;
	this.email = email;
	Designation = designation;
	DOJ = dOJ;
}


}

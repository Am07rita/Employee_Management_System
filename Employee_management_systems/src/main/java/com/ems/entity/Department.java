package com.ems.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name="dept")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Department  {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int deptId;
@Column(name="department_name",length=20,nullable = false)
private String deptName;
@Column(name="total_employee",length=10)
private int totalemp;
@Column(length=10)
private String location;
@OneToMany(fetch = FetchType.LAZY)
private List<Employee> employee;
@OneToOne
private Manager manager;
}

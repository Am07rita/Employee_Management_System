package com.ems.model;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class DepartmentDTO {
	private int deptId;
	private String deptName;
	private int totalemp;
	private String location;
	private List<EmployeeDTO>employees;
}

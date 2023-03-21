package com.ems.dao;

import com.ems.entity.Department;


public interface DepartmentDAO {
 void saveDepartment(Department dept) ;
	Department getDepartmentUsingId(int id);
	Department UpdateDepartment(int id,Department department);
	void assignEmployeeToDept(int employeeId,int deptId);
	void deleteDeprtmentById(int id);
	void assignManagerTodept(int managerId,int deptId);
}

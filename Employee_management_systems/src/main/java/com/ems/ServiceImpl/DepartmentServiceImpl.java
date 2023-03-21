package com.ems.ServiceImpl;

import java.util.Date;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ems.Service.DepartmentService;
import com.ems.dao.DepartmentDAO;
import com.ems.daoimpl.DepartmentDaoImpl;
import com.ems.entity.Department;
import com.ems.exception.GlobalException;
import com.ems.model.DepartmentDTO;



public class DepartmentServiceImpl implements DepartmentService {
	private static final Logger logger=LoggerFactory.getLogger(EmployeeServiceImpl.class);
	DepartmentDAO departmentDAO =new DepartmentDaoImpl();
	
//method to save department
@Override
	public void saveDepartment(Department dept) {	
	logger.info("New Department details added!!");
	departmentDAO.saveDepartment(dept);
	}

//method to check department by using id
	@Override
	public DepartmentDTO getDepartmentUsingId(int id) {
		Department department=departmentDAO.getDepartmentUsingId(id);
		if(department!=null)
		{
			logger.info("Department with id "+id+" was retrieved at "+new Date());
			return new ModelMapper().map(department,DepartmentDTO.class);
		}
		else 
			throw new GlobalException("Department details not found!!");
	
	}
	
	
	//method to update department
	@Override
	public DepartmentDTO updateDepartment(int id, Department department) {
		Department depart=departmentDAO.UpdateDepartment(id, department);
		if(depart!=null) {
			logger.info("Department details updated");
			return new ModelMapper().map(depart,DepartmentDTO.class);
	}
	else
		throw new GlobalException("Department with id "+id+" not found!!");
		}
	
	//method to assign employee to department
	@Override
	public void assignEmployeeToDept(int employeeId, int deptId) {
		logger.info("Employee Id assigned to department successfully!");
		departmentDAO.assignEmployeeToDept(employeeId, deptId);
	}
	
	//method to assign manager to department
	@Override
	public void assignManagerToDept(int ManagerId, int deptId) {
	logger.info("Manager Id assigned to department successfully!");
		departmentDAO.assignManagerTodept(ManagerId, deptId);
	}
	
	//method to delete department
	@Override
	public void deleteDepartmentById(int id) {
		logger.info("Department details deleted successfully!!");
		departmentDAO.deleteDeprtmentById(id);
		
	}
	
	
}


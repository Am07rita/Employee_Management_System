package com.ems.ServiceImpl;

import java.util.Date;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ems.Service.EmployeeService;
import com.ems.dao.EmployeeDAO;
import com.ems.daoimpl.EmployeeDaoImpl;
import com.ems.entity.Employee;
import com.ems.exception.GlobalException;
import com.ems.model.EmployeeDTO;

public class EmployeeServiceImpl implements  EmployeeService {
	private static final Logger logger=LoggerFactory.getLogger(EmployeeServiceImpl.class);
EmployeeDAO employeeDAO=new EmployeeDaoImpl();

//method to save employee
	@Override
	public void saveEmployee(Employee employee) {
		logger.info("New employee details added!!");
		employeeDAO.saveEmployee(employee);
		
	}
	
	//method to check employee using id
	@Override
	public EmployeeDTO getEmployeeUsingId(int id) {
		Employee employee=employeeDAO.getEmployeeUsingId(id);
		if(employee!=null)
		{
		logger.info("Employee with id "+id+" was retrieved at "+new Date());
			return new ModelMapper().map(employee,EmployeeDTO.class);
		}
		else 
			throw new GlobalException("Employee details not found!!");
		
	}
	//method to update employee
	@Override
	public EmployeeDTO updateEmployee(int id, Employee employee) {
		Employee emp=employeeDAO.updateEmployee(id, employee);
		if(emp!=null)
		{
			logger.info("Employee details updated");
			return new ModelMapper().map(emp,EmployeeDTO.class);
			
		}
		else
		throw new GlobalException("Employee with id "+id+" not found!!");
	}
	
	//method to delete employee
	@Override
	public void deleteEmployeeById(int id) {
		logger.info("Employee details deleted successfully!!");
		employeeDAO.deleteEmployeeById(id);
		
	}
	
	//method to update employee using email
	@Override
	public EmployeeDTO getEmployeeByEmail(String email) {
		Employee emp=employeeDAO.getEmployeeByEmail(email);
		
		if(emp!=null)
		{
			logger.info("Employee with email "+email+" was retrieved at "+new Date());
			return new ModelMapper().map(emp,EmployeeDTO.class);
		}
		else 
			throw new GlobalException("Employee with email "+email+" not found!!");
		
	}
	
	//method for login section
	@Override
	public boolean login(String userName, String password) {
		return employeeDAO.login(userName, password);
		
	}
}
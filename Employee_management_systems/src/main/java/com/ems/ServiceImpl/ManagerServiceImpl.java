package com.ems.ServiceImpl;



import java.util.Date;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ems.Service.ManagerService;
import com.ems.dao.ManagerDAO;
import com.ems.daoimpl.ManagerDaoImpl;
import com.ems.entity.Manager;
import com.ems.exception.GlobalException;
import com.ems.model.ManagerDTO;

public class ManagerServiceImpl implements ManagerService {
	private static final Logger logger=LoggerFactory.getLogger(EmployeeServiceImpl.class);
	ManagerDAO managerDAO=new ManagerDaoImpl();

//method to save manager
	@Override
	public void saveManager(Manager manager) {
		logger.info("New Manager details added!!");
		managerDAO.saveManager(manager);	
	}
	
	//method to check manager using id
	@Override
	public ManagerDTO getManagerUsingId(int id) {
		Manager manager=managerDAO.getManagerUsingId(id);
		if(manager!=null)
		{
			logger.info("Manager with id "+id+" was retrieved at "+new Date());
			return new ModelMapper().map(manager,ManagerDTO.class);
		}
		else 
			throw new GlobalException("Manager details not found!!");
		
	}
	
	//method to update manager
	@Override
	public ManagerDTO updateManager(int id, Manager manager) {
		Manager manag=managerDAO.updateManager(id, manager);
		if(manag!=null)
		{
			logger.info("Manager details updated");
			return new ModelMapper().map(manag,ManagerDTO.class);
			
		}
		else
		throw new GlobalException("Manager with id "+id+" not found!!");
		
	}
	
	//method for login section
	@Override
	public boolean login(String userName, String password) {
		
		return managerDAO.login(userName,password);
		
	}
	
	//method to delete manager
	@Override
	public void deleteManagerById(int id) {
		logger.info("Manager details deleted successfully!!");
		managerDAO.deleteManagerById(id);
		
	}
	
	//method to assign employee to manager
	@Override
	public void assignEmployeeToManag(int employeeId, int managId) {
		logger.info("Employee Id assigned to manager successfully!");
	managerDAO.assignEmployeeToManag(employeeId, managId);
		
	}
	
}

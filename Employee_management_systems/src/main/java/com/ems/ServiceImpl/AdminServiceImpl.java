package com.ems.ServiceImpl;



import java.util.Date;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ems.Service.AdminService;
import com.ems.dao.AdminDAO;
import com.ems.daoimpl.AdminDaoImpl;
import com.ems.entity.Admin;
import com.ems.exception.GlobalException;
import com.ems.model.AdminDTO;


public class AdminServiceImpl implements AdminService{
	private static final Logger logger=LoggerFactory.getLogger(EmployeeServiceImpl.class);
AdminDAO adminDao=new AdminDaoImpl();
	
//method to save admin
@Override
	public void saveAdmin(Admin admin) {
	logger.info("New Admin details added!!");
		adminDao.saveAdmin(admin);	
	}


//method for login section
	@Override
	public boolean login(String userName, String password) {
		return adminDao.login(userName, password);
		
	}

	
	//method to delete admin using id
	@Override
	public AdminDTO getAdminUsingId(int id) {
		
		Admin admin=adminDao.getAdminUsingId(id);
		if(admin!=null)
		{
			logger.info("Admin with id "+id+" was retrieved at "+new Date());
			return new ModelMapper().map(admin,AdminDTO.class);
		}
		else 
			throw new GlobalException("Admin details not found!!");
		
	}

	
	//method for update admin
	@Override
	public AdminDTO updateAdmin(int id, Admin admin) {
		
Admin admin1=adminDao.updateAdmin(id,admin);
		if(admin1!=null)
		{
			logger.info("Admin details updated");
			return new ModelMapper().map(admin,AdminDTO.class);
		}
			else
				throw new GlobalException("Admin with id "+id+" not found!!");
		}
	
	
	//method for delete admin
	@Override
	public void deleteAdminById(int id) {
		logger.info("Admin details deleted successfully!!");
	adminDao.deleteAdminById(id);
		
	}

}

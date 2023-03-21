package com.ems.dao;


import com.ems.entity.Manager;

public interface ManagerDAO {
	 void saveManager(Manager manager);
	 boolean login(String userName,String password);
	 Manager getManagerUsingId(int id);
	 Manager updateManager(int id, Manager manager);
	 void deleteManagerById(int id);
	 void assignEmployeeToManag(int employeeId,int managId);
}


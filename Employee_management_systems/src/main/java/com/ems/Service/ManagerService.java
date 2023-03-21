package com.ems.Service;

import com.ems.entity.Manager;
import com.ems.model.ManagerDTO;

public interface ManagerService {
void saveManager(Manager manager);
ManagerDTO getManagerUsingId(int id);
ManagerDTO updateManager(int id, Manager manager);
void deleteManagerById(int id);
boolean login(String userName,String password);
void assignEmployeeToManag(int employeeId,int managId);
}

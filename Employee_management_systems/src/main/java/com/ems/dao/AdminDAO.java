package com.ems.dao;

import com.ems.entity.Admin;


public interface AdminDAO {
void saveAdmin(Admin admin);
Admin getAdminUsingId(int id);
Admin updateAdmin(int id, Admin admin );
void deleteAdminById(int id);
boolean login(String userName,String password);

}

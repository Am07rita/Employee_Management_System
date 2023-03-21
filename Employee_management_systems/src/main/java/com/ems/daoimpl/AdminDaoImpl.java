package com.ems.daoimpl;


import javax.swing.JOptionPane;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.ems.config.Hibernateutil;
import com.ems.dao.AdminDAO;
import com.ems.entity.Admin;


public class AdminDaoImpl implements AdminDAO {

	//method to save admin
	@Override
	public void saveAdmin(Admin admin) {
		try(Session session=Hibernateutil.getSession())//try block
		{
			session.beginTransaction();
			session.save(admin);
			session.getTransaction();
			session.clear();
		}
		catch(HibernateException e)
		{
			System.out.println(e.getMessage());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

	
	//method for login section
	@Override
	public boolean login(String userName, String password) {
		try(Session session=Hibernateutil.getSession())
		{
		int id=Integer.parseInt(JOptionPane.showInputDialog("Enter Id: ", "Type here..."));
		Admin admin=session.get(Admin.class,id);
		if(admin.getUsername().equals(userName)&& admin.getPassword().equals(password)
				&& admin.getRole().equals("admin"))
		{
			JOptionPane.showMessageDialog(null,"Log in successfully!!");
			return true;
		}
		else
		{
			JOptionPane.showMessageDialog(null,"wrong credential!!");
			return false;
		}
		}
		
	}

	//method for after login section
	@Override
	public Admin getAdminUsingId(int id) {
		try(Session session= Hibernateutil.getSession())
		{
			Admin admin = session.get(Admin.class,id);
		    return admin;
		}
		catch(HibernateException e)
		{
			System.out.println(e.getMessage());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
	}
		return null;
	}

	
	//method for update admin
	@Override
	public Admin updateAdmin(int id, Admin admin) {
		try(Session session=Hibernateutil.getSession())
		{
			Admin admin1 = session.load(Admin.class,id);
			admin1.setAdminName(admin.getAdminName());
			admin1.setAdminEmail(admin.getAdminEmail());
			admin1.setUsername(admin1.getUsername());
			admin1.setPassword(admin.getPassword());
			
			session.beginTransaction();
			 session.saveOrUpdate(admin1);
			 session.getTransaction().commit();
			 
			 return admin;
		}
		catch(HibernateException e)
		{
			System.out.println(e.getMessage());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			
		}
		return null;
	}

	//method for delete admin
	@Override
	public void deleteAdminById(int id) {
		
		try(Session session=Hibernateutil.getSession())
		{
		Admin admin=session.load(Admin.class,id);
		session.beginTransaction();
		int input=JOptionPane.showConfirmDialog(null,"Do you want to delete?","Are you sure ?",JOptionPane.YES_NO_OPTION);
		if(input==0)
		{
			session.delete(admin);
		
		}
		else
		{
			JOptionPane.showMessageDialog(null,"User wants to retain it!");
		
		}
		session.getTransaction().commit();
		}
		catch(HibernateException e)
		{
			System.out.println(e.getMessage());
		}
	}

}

package com.ems.daoimpl;


import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import com.ems.config.Hibernateutil;
import com.ems.dao.ManagerDAO;
import com.ems.entity.Employee;
import com.ems.entity.Manager;

public class ManagerDaoImpl implements ManagerDAO {

	//method to save manager
	@Override
	public void saveManager(Manager manager) {
		try(Session session=Hibernateutil.getSession())
		{
			session.beginTransaction();
			session.save(manager);
			session.getTransaction().commit();
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

	//method to check manager using id
	@Override
	public Manager getManagerUsingId(int id) {
		try(Session session= Hibernateutil.getSession())
		{
			Manager manager = session.get(Manager .class,id);
		    return manager ;
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
		

	//method to update manager
	@Override
	public Manager updateManager(int id, Manager manager) {
		try(Session session=Hibernateutil.getSession())
		{
			Manager manag=session.load(Manager.class,id);
			 manag.setMangName(manager.getMangName());
			 manag.setMangAddress(manager.getMangAddress());
			 manag.setContact(manager.getContact());
			 manag.setEmail(manager.getEmail());
			 manag.setSalary(manager.getSalary());
			 manag.setUsername(manager.getUsername());
			 manag.setPassword(manager.getPassword());
			 
			 session.beginTransaction();
			 session.saveOrUpdate(manag);
			 session.getTransaction().commit();
			 
			 return manag;//returning manager entity
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

	//method to delete manager
	@Override
	public void deleteManagerById(int id) {
		
		try(Session session=Hibernateutil.getSession())
		{
		Manager manager=session.load(Manager.class,id);
		session.beginTransaction();
		int input=JOptionPane.showConfirmDialog(null,"Do you want to delete?","Are you sure ?",JOptionPane.YES_NO_OPTION);
		if(input==0)
		{
			session.delete(manager);
		
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

	//method for login section
	@Override
	public boolean login(String userName, String password) {
		try(Session session=Hibernateutil.getSession())
		{
		int id=Integer.parseInt(JOptionPane.showInputDialog("Enter Id: ", "Type here..."));
		Manager manager=session.get(Manager.class,id);
		if(manager.getUsername().equals(userName)&& manager.getPassword().equals(password)
				&& manager.getRole().equals("Manager"))
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

	//method to assign employee to manager
	@Override
	public void assignEmployeeToManag(int employeeId, int managId) {
		try(Session session=Hibernateutil.getSession())
		{
		Employee emp=session.get(Employee.class,employeeId);
		Manager manag=session.get(Manager.class, managId);
	
		List<Employee> employees=new ArrayList<>();
		
		employees.add(emp);
		
		manag.setEmployee(employees);
		emp.setManager(manag);
		
	
		
		session.beginTransaction();
		session.saveOrUpdate(manag);
		session.getTransaction().commit();
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
			
	
	}



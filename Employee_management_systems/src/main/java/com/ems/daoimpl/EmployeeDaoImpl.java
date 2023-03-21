package com.ems.daoimpl;


import javax.swing.JOptionPane;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.hibernate.Session;

import com.ems.config.Hibernateutil;
import com.ems.dao.EmployeeDAO;

import com.ems.entity.Employee;


public class EmployeeDaoImpl implements EmployeeDAO{

	//method to save employee
	@Override
	public void saveEmployee(Employee employee) {
		
		try(Session session=Hibernateutil.getSession())
		{
			session.beginTransaction();
			session.save(employee);
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

	
	//method to check employee using id
	@Override
	public Employee getEmployeeUsingId(int id) {
		try(Session session= Hibernateutil.getSession())
		{
			Employee employee = session.get(Employee.class,id);
		    return employee;
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

	//method to update employee
	public Employee updateEmployee(int id, Employee employee) {
		try(Session session=Hibernateutil.getSession())
		{
			Employee emp=session.load(Employee.class,id);
			 emp.setEmpName(employee.getEmpName());
			 emp.setEmpAddress(employee.getEmpAddress());
			 emp.setSalary(employee.getSalary());
			 emp.setContact(employee.getContact());
			 emp.setEmail(employee.getEmail());
			 emp.setDesignation(employee.getDesignation());
			 emp.setDOJ(employee.getDOJ());
			 emp.setUsername(employee.getUsername());
			 emp.setPassword(employee.getPassword());
			 
			 emp.setManager(emp.getDept().getManager());
			 session.beginTransaction();
			 session.saveOrUpdate(emp);
			 session.getTransaction().commit();
			 
			 return emp;//returning employee entity
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

	
	//method to delete employee
	@Override
	public void deleteEmployeeById(int id) {
		try(Session session=Hibernateutil.getSession())
		{
		Employee employee=session.load(Employee.class,id);
		session.beginTransaction();
		int input=JOptionPane.showConfirmDialog(null,"Do you want to delete?","Are you sure ?",JOptionPane.YES_NO_OPTION);
		if(input==0)
		{
			session.delete(employee);
		//	session.evict(employee);
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

	
	//method to update employee using email
	@Override
	public Employee getEmployeeByEmail(String email) {
		try(Session session=Hibernateutil.getSession())
		{
			String query="from Employee e where e.email=:a";
			Query q=session.createQuery(query);
			q.setParameter("a", email);
			
		Employee emp=(Employee)q.uniqueResult();
		return emp;
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

	//method for login section
	@Override
	public boolean login(String userName, String password) {
		try(Session session=Hibernateutil.getSession())
		{
		int id=Integer.parseInt(JOptionPane.showInputDialog("Enter Id: ", "Type here..."));
		Employee employee=session.get(Employee.class,id);
		if(employee.getUsername().equals(userName)&& employee.getPassword().equals(password)
				&& employee.getRole().equals("employee"))
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

}


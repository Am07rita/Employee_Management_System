package com.ems.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import com.ems.config.Hibernateutil;
import com.ems.dao.DepartmentDAO;
import com.ems.entity.Department;
import com.ems.entity.Employee;
import com.ems.entity.Manager;


public class DepartmentDaoImpl implements DepartmentDAO{

	
	//method to save department
	public void saveDepartment(Department dept) 
	{
		try(Session session=Hibernateutil.getSession())
		{
			session.beginTransaction();
			session.save(dept);
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
//method to check department by using id
	@Override
	public Department getDepartmentUsingId(int id) {
		try(Session session=Hibernateutil.getSession())
		{
			Department dept=session.get(Department.class,id);
		return dept;
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

	
	//method to update department
	public Department UpdateDepartment(int id, Department department) {
		try(Session session=Hibernateutil.getSession())
		{
			Department dept=session.load(Department.class,id);
			dept.setDeptName(department.getDeptName());
			dept.setTotalemp(department.getTotalemp());
			dept.setLocation(department.getLocation());
			
			session.beginTransaction();
			 session.saveOrUpdate(dept);
			 session.getTransaction().commit();
		return dept;
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

	//method to assign employee to department
	@Override
	public void assignEmployeeToDept(int employeeId, int deptId) {
		try(Session session=Hibernateutil.getSession())
		{
		Employee emp=session.get(Employee.class,employeeId);
		Department dept=session.get(Department.class, deptId);
	
		List<Employee> employees=new ArrayList<>();
		
		employees.add(emp);
		
		dept.setEmployee(employees);
		emp.setDept(dept);
		emp.setManager(emp.getDept().getManager());
		dept.setTotalemp(dept.getTotalemp()+1);
		
		session.beginTransaction();
		session.saveOrUpdate(dept);
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

	
	//method to assign manager to department
	@Override
	public void assignManagerTodept(int managerId, int deptId) {
		try(Session session=Hibernateutil.getSession())
		{
		Manager manag=session.get(Manager.class,managerId);
		Department dept=session.get(Department.class, deptId);
	
		List<Manager> manager1=new ArrayList<>();
		
		manager1.add(manag);
		
		dept.setManager(manag);
		

		session.beginTransaction();
		session.saveOrUpdate(dept);
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

	
	//method to delete department
	@Override
	public void deleteDeprtmentById(int id) {
	
		try(Session session=Hibernateutil.getSession())
		{
			Department dept=session.load(Department.class,id);
		session.beginTransaction();
		int input=JOptionPane.showConfirmDialog(null,"Do you want to delete?","Are you sure ?",JOptionPane.YES_NO_OPTION);
		if(input==0)
		{
			session.delete(dept);
		
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
	
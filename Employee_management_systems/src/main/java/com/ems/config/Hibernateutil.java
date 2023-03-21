package com.ems.config;

import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.ems.entity.Admin;
import com.ems.entity.Department;
import com.ems.entity.Employee;
import com.ems.entity.Manager;
import com.ems.entity.User;

public class Hibernateutil {

	public static SessionFactory sessionfactory; 
	

	public static SessionFactory getSessionFactory()
	{
		if (sessionfactory==null)
		{
			try
			{
				Configuration configuration=new Configuration();
				Properties property=new Properties();
				property.put(Environment.DRIVER,"com.mysql.jdbc.Driver");
				property.put(Environment.URL,"jdbc:mysql://localhost:3306/ems");
				property.put(Environment.USER,"root");
				property.put(Environment.PASS, "root");
				property.put(Environment.DIALECT,"org.hibernate.dialect.MySQL8Dialect" );
				property.put(Environment.SHOW_SQL,"true");
				property.put(Environment.HBM2DDL_AUTO,"update");
				property.put(Environment.CURRENT_SESSION_CONTEXT_CLASS,"thread"); 
				property.put(Environment.ENABLE_LAZY_LOAD_NO_TRANS,"true");
				
				configuration.setProperties(property);
				configuration.addAnnotatedClass(Employee.class);
				configuration.addAnnotatedClass(Department.class);
				configuration.addAnnotatedClass(Manager.class);
				configuration.addAnnotatedClass(Admin.class);
				configuration.addAnnotatedClass(User.class);
				ServiceRegistry register=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
			System.out.println("Hibernate Java Configuration Registery created!!!");
			
			sessionfactory=configuration.buildSessionFactory(register);
			return sessionfactory;
			}
			catch(HibernateException e)
			{
				System.out.println(e.getMessage());
			}
			
		}
		return sessionfactory;

	}
	public static Session getSession()
	{
		return getSessionFactory().openSession();
	}
}

package com.ems;

import java.time.LocalDate;
import java.util.Scanner;

import javax.swing.JOptionPane;
import com.ems.Service.EmployeeService;
import com.ems.ServiceImpl.EmployeeServiceImpl;
import com.ems.entity.Employee;
import com.ems.exception.GlobalException;
import com.ems.model.EmployeeDTO;

public class EmployeeCRUD {
	
	static Scanner sc=new Scanner(System.in);
	static EmployeeService empService=new EmployeeServiceImpl();
	
	//To save new employee details
	public static void saveEmployee() {	
	Employee emp=new Employee();
//	sc.nextLine();
//	System.out.println("Enter Name: ");
//	String name=sc.nextLine();
//	System.out.println("Enter Address: ");
//	String add=sc.nextLine();
//	System.out.println("Enter Salary: ");
//	double sal=sc.nextDouble();
//	System.out.println("Enter Contact: ");
//	String con=sc.next();
//	sc.nextLine();
//	System.out.println("Enter Email: ");
//	String email=sc.nextLine();
//	System.out.println("Enter Designation: ");
//	String des=sc.nextLine();
//	System.out.println("Enter DOJ: ");
//   LocalDate date=LocalDate.parse(sc.next());
//   System.out.println("Enter UserName: ");
//	String user=sc.next();
//	System.out.println("Enter Password: ");
//	String pass=sc.next();
	
	String name=JOptionPane.showInputDialog("Enter Name: ","Type here ");
	String add=JOptionPane.showInputDialog("Enter Address: ","Type here ");
	Double sal=Double.parseDouble(JOptionPane.showInputDialog("Enter Salary: ","Type here "));
	String con=JOptionPane.showInputDialog("Enter Contact No.: ","Type here ");
	String email=JOptionPane.showInputDialog("Enter Email: ","Type here ");
	String des=JOptionPane.showInputDialog("Enter Designation: ","Type here ");
	LocalDate date=LocalDate.parse(JOptionPane.showInputDialog("Enter D.O.J: ","Type here "));
	String user=JOptionPane.showInputDialog("Enter Username: ","Type here ");
	String pass=JOptionPane.showInputDialog("Enter Password: ","Type here ");
	
	emp.setEmpName(name);
	emp.setEmpAddress(add);
	emp.setSalary(sal);
	emp.setContact(con);
	emp.setEmail(email);
	emp.setDesignation(des);
	emp.setDOJ(date);
	emp.setUsername(user);
	emp.setPassword(pass);
	emp.setRole("employee");
	//emp.setManager(emp.getDept().getManager());
	empService.saveEmployee(emp);
	System.out.println("Employee details saved!!");
	}
	
	//login section for employee
	public static void login()
	{
	empService.login(JOptionPane.showInputDialog("Enter Username: ","Type here"),JOptionPane.showInputDialog("Enter Password: ","Type here"));
	}
	
	//details of after login section,operation performed by the employee
	public static void afterLoginEmployee()
	{
		do {

		
		System.out.println();
		System.out.println("A)  Check employee Details by ID\nB) Check employee Details by Email\nC)  Exit");
		String choice =JOptionPane.showInputDialog("Enter Choice","TYpe Here");
		switch (choice)
		{
		case "A":
		EmployeeCRUD.getEmployee();
		break;
		case "B":
			EmployeeCRUD.getEmployeeByEmail();
		break;
		case "C":
			App.mainUser();//return to main employee section
		break;
		
		}
		}while(true);
	}
	
	
	//To check employee details by using id
	public static void getEmployee()throws GlobalException
	{
		int id =Integer.parseInt(JOptionPane.showInputDialog("Enter Id to Search: ","Type here.."));
	EmployeeDTO empl=empService.getEmployeeUsingId(id);
	System.out.println("Employee Name: "+empl.getEmpName());
	System.out.println("Employee Address: "+empl.getEmpAddress());
	System.out.println("Employee Salary: "+empl.getSalary());
	System.out.println("Employee Contact No.: "+empl.getContact());
	System.out.println("Employee Email: "+empl.getEmail());
	System.out.println("Employee Designation: "+empl.getDesignation());
	System.out.println("Employee D.O.J: "+empl.getDOJ());
	System.out.println("Employee Role: "+empl.getRole());
	}
	
	//To update employee details
	public static void updateEmployee()throws GlobalException
	{
		Employee emp1=new Employee();
		
	String name=JOptionPane.showInputDialog("Enter Name: ","Type here ");
	String add=JOptionPane.showInputDialog("Enter Address: ","Type here ");
	Double sal=Double.parseDouble(JOptionPane.showInputDialog("Enter Salary: ","Type here "));
	String con=JOptionPane.showInputDialog("Enter Contact No.: ","Type here ");
	String email=JOptionPane.showInputDialog("Enter Email: ","Type here ");
	String des=JOptionPane.showInputDialog("Enter Designation: ","Type here ");
	LocalDate date=LocalDate.parse(JOptionPane.showInputDialog("Enter D.O.J: ","YYYY-MM-DD "));
	String user=JOptionPane.showInputDialog("Enter Username: ","Type here ");
	String pass=JOptionPane.showInputDialog("Enter Password: ","Type here ");
	
	 emp1.setEmpName(name);
	 emp1.setEmpAddress(add);
	 emp1.setSalary(sal);
	emp1.setContact(con);
	emp1.setEmail(email);
	emp1.setDesignation(des);
	emp1.setDOJ(date);
	emp1.setUsername(user);
	emp1.setPassword(pass);
	//emp1.setRole("employee");
	
	empService.updateEmployee(Integer.parseInt(JOptionPane.showInputDialog("Enter id to update: ","Type here....")),emp1);
	System.out.println("Employee details updated successfully!!!!");
	}
	
	//To delete employee details by using id
	public static void deleteEmployee()
	{
		int id=Integer.parseInt(JOptionPane.showInputDialog("Enter id to delete","Type here"));
	empService.deleteEmployeeById(id);
	JOptionPane.showMessageDialog(null,"Object is deleted!!!");
	}
	
	//To check employee details by using email
	public static void getEmployeeByEmail() {
		String email=JOptionPane.showInputDialog("Enter Email to search","Type here");
		EmployeeDTO emps=empService.getEmployeeByEmail(email);
		
		System.out.println("\nEmployee Name: " + emps.getEmpName());
		System.out.println("Employee Address: " + emps.getEmpAddress());
		System.out.println("Employee Salary: " + emps.getSalary());
		System.out.println("Employee Contact: " + emps.getContact());
		System.out.println("Employee Email: " + emps.getEmail());
		System.out.println("Employee Designation: " + emps.getDesignation());
		System.out.println("Employee D.O.J: " + emps.getDOJ());
	}

	
	
}

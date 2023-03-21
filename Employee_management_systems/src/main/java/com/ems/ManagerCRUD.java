package com.ems;

import java.util.Scanner;

import javax.swing.JOptionPane;

import com.ems.Service.ManagerService;
import com.ems.ServiceImpl.ManagerServiceImpl;
import com.ems.entity.Manager;
import com.ems.exception.GlobalException;
import com.ems.model.ManagerDTO;

public class ManagerCRUD {

	static Scanner sc=new Scanner (System.in);  
static ManagerService managService=new ManagerServiceImpl(); 

//To save new manager details
public static void saveManager() {
Manager manag=new Manager();

String name=JOptionPane.showInputDialog("Enter Name: ","Type here ");
String add=JOptionPane.showInputDialog("Enter Address: ","Type here ");
Double sal=Double.parseDouble(JOptionPane.showInputDialog("Enter Salary: ","Type here "));
String con=JOptionPane.showInputDialog("Enter Contact No.: ","Type here ");
String email=JOptionPane.showInputDialog("Enter Email: ","Type here");
String user=JOptionPane.showInputDialog("Enter Username: ","Type here ");
String pass=JOptionPane.showInputDialog("Enter Password: ","Type here ");


manag.setMangName(name);
manag.setMangAddress(add);
manag.setSalary(sal);
manag.setContact(con);
manag.setEmail(email);
manag.setUsername(user);
manag.setPassword(pass);
manag.setRole("Manager");

managService.saveManager(manag);
System.out.println("Manager details saved!!!");
}

//login section for manager
public static void login()
{
managService.login(JOptionPane.showInputDialog("Enter Username: ","Type here"),JOptionPane.showInputDialog("Enter Password: ","Type here"));
}

//operation performed by the manager after login section
public static void afterLoginManager()
{
	do {
		
	
	System.out.println();
	System.out.println("A)  Check Manager Details by ID\nB) To update Manager\nC) To Assign Employee to Manager"
			+ "\nD) Exit ");
	String choice =JOptionPane.showInputDialog("Enter Choice","TYpe Here");
	switch (choice)
	{
	case "A":
	ManagerCRUD.getManager();
	break;
	case "B":
		ManagerCRUD.updateManager();
	break;
	case "C":
		ManagerCRUD.assignEmployeetoManager();
		break;
	case"D":
	App.mainManager();
	break;
	}
	}while(true);
	
}


//To check manager details using id
public static void getManager()throws GlobalException
{
	int id =Integer.parseInt(JOptionPane.showInputDialog("Enter Id to Search: ","Type here.."));
ManagerDTO manag=managService.getManagerUsingId(id);
System.out.println("Manager Name: "+manag.getMangName());
System.out.println("Manager Address: "+manag.getMangAddress());
System.out.println("Manager Salary: "+manag.getSalary());
System.out.println("Manager Contact No.: "+manag.getContact());
System.out.println("Manager Email: "+manag.getEmail());
System.out.println("Manager Role: "+manag.getRole());
}


//To update manager details
public static void updateManager()throws GlobalException
{
	Manager manag=new Manager();
	
String name=JOptionPane.showInputDialog("Enter Name: ","Type here ");
String add=JOptionPane.showInputDialog("Enter Address: ","Type here ");
Double sal=Double.parseDouble(JOptionPane.showInputDialog("Enter Salary: ","Type here "));
String con=JOptionPane.showInputDialog("Enter Contact No.: ","Type here ");
String email=JOptionPane.showInputDialog("Enter Email: ","Type here ");	String user=JOptionPane.showInputDialog("Enter Username: ","Type here ");
String pass=JOptionPane.showInputDialog("Enter Password: ","Type here ");

manag.setMangName(name);
manag.setMangAddress(add);
manag.setSalary(sal);
manag.setContact(con);
manag.setEmail(email);
manag.setUsername(user);
manag.setPassword(pass);

managService.updateManager(Integer.parseInt(JOptionPane.showInputDialog("Enter id to update: ","Type here....")),manag);
System.out.println("Manager details updated successfully!!!!");

}


//To delete any manager details
public static void deleteManager()
{
	int id=Integer.parseInt(JOptionPane.showInputDialog("Enter id to delete","Type here"));
managService.deleteManagerById(id);
JOptionPane.showMessageDialog(null,"Object is deleted!!!");
}

//To assign Employee to manager
public static void assignEmployeetoManager() {
	int managId=Integer.parseInt(JOptionPane.showInputDialog("Enter Manager Id: ","Type here"));
	int empId=Integer.parseInt(JOptionPane.showInputDialog("Enter Employee Id: ","Type here"));
managService.assignEmployeeToManag(empId, managId);

JOptionPane.showMessageDialog(null,"Employee has been assigned successfully!!");
}
}
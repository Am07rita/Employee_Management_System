package com.ems;

import javax.swing.JOptionPane;

import com.ems.Service.AdminService;
import com.ems.ServiceImpl.AdminServiceImpl;
import com.ems.entity.Admin;
import com.ems.exception.GlobalException;
import com.ems.model.AdminDTO;

public class AdminCRUD {

static AdminService adminService=new AdminServiceImpl();


//To save new admin details
public static void saveAdmin() {
	Admin admin =new Admin();
	String name=JOptionPane.showInputDialog("Enter name", "Type here");
     String email=JOptionPane.showInputDialog("Enter email", "Type here");
    String user=JOptionPane.showInputDialog("Enter user_name", "Type here");
	String pass=JOptionPane.showInputDialog("Enter password", "Type here");;
	
	admin.setAdminName(name);
	admin.setAdminEmail(email);
	admin.setUsername(user);
	admin.setPassword(pass);
	admin.setRole("admin");
	
	adminService.saveAdmin(admin);
	System.out.println("New admin details added successfully!!");
	
}
//To check admin details by using id
public static void getAdmin()throws GlobalException
{
	int id =Integer.parseInt(JOptionPane.showInputDialog("Enter Id to Search: ","Type here.."));
AdminDTO admin=adminService.getAdminUsingId(id);
System.out.println("Admin Name: "+admin.getAdminName());
System.out.println("Admin Email: "+admin.getAdminEmail());
System.out.println("Admin Role: "+admin.getRole());

}
//To update admin details
public static void updateAdmin()throws GlobalException
{
	Admin admin1=new Admin();
	String name=JOptionPane.showInputDialog("Enter Name: ","Type here ");
	String email=JOptionPane.showInputDialog("Enter Name: ","Type here ");
	String user=JOptionPane.showInputDialog("Enter Username: ","Type here ");
	String pass=JOptionPane.showInputDialog("Enter Password: ","Type here ");
	
	admin1.setAdminName(name);
	admin1.setAdminEmail(email);
	admin1.setUsername(user);
	admin1.setPassword(pass);
	
	adminService.updateAdmin(Integer.parseInt(JOptionPane.showInputDialog("Enter id to update: ","Type here....")),admin1);
	System.out.println("Admin details updated successfully!!!!");
}
//To delete any admin details
public static void deleteAdmin()
{
	int id=Integer.parseInt(JOptionPane.showInputDialog("Enter id to delete","Type here"));
adminService.deleteAdminById(id);
JOptionPane.showMessageDialog(null,"Object is deleted!!!");
}
//login section for admin
public static void login()
{
	
	adminService.login(JOptionPane.showInputDialog("Enter Username: ","Type here"),JOptionPane.showInputDialog("Enter Password: ","Type here"));
	
}
//Operations performed after login section from admin
public static void afterLoginAdmin()
{
	do {
	System.out.println();
	System.out.println("A) Save new Admin\nB) To Check an admin By Id\nC) To Update an Admin details\nD) To delete an Admin"
			+ "\nE) Save New Department\nF) To check department details using Id\nG) Update Departmenent details\nH) To delete department"
			+ "\nI) Assign employee to department\nJ) To Save an Employee\nK) To Update an Employee\nL) To check Employee By Id"
			+"\nM) To check Employee By Email\nN) To Delete an Employee\nO) To save a Manager\nP) To update a Manager"
			+ "\nQ) To Check Manager By Id\nR) To Delete a Manager\nS) Assign Manager to department\nT) Exit ");
	String choice =JOptionPane.showInputDialog("Enter Choice","TYpe Here");
	switch (choice)
	{
	case "A":
		AdminCRUD.saveAdmin();
		break;
	case "B":
		AdminCRUD.getAdmin();
		break;
	case "C":
		AdminCRUD.updateAdmin();
		break;
	case "D":
		AdminCRUD.deleteAdmin();
		break;
		
		
	case "E":
	DepartmentCRUD.saveDepartment();
	break;
	case "F":
	DepartmentCRUD.getDepartment();
	break;
	case "G":
	DepartmentCRUD.updateDepartment();
	break;
	case "H":
	DepartmentCRUD.deleteDepartment();
	break;
	
	
	case "I":
	DepartmentCRUD.assign();
	break;
	
	
	case "J":
	EmployeeCRUD.saveEmployee();
	break;
	case"K":
	EmployeeCRUD.updateEmployee();
	break;
	case "L":
	EmployeeCRUD.getEmployee();
	break;
	case "M":
	EmployeeCRUD.getEmployeeByEmail();
	break;
	case"N":
	EmployeeCRUD.deleteEmployee();
	break;
	
	
	case"O":
	ManagerCRUD.saveManager();
	break;
	case"P":
	ManagerCRUD.updateManager();
	break;
	case"Q":
	ManagerCRUD.getManager();
	break;
	case"R":
	ManagerCRUD.deleteManager();
	break;
	case"S":
	DepartmentCRUD.assignmanager();
	break;
	
	
	case"T":
	App.mainAdmin();//return to main admin section again
	break;
	}
	}while(true);
}
}

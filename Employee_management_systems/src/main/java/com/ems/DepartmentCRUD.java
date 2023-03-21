package com.ems;

import java.util.Scanner;

import javax.swing.JOptionPane;

import com.ems.Service.DepartmentService;
import com.ems.ServiceImpl.DepartmentServiceImpl;
import com.ems.entity.Department;
import com.ems.exception.GlobalException;
import com.ems.model.DepartmentDTO;



public class DepartmentCRUD {
	static Scanner sc=new Scanner(System.in);
	static DepartmentService depService=new DepartmentServiceImpl();
	
	//To save new department details
	public static void saveDepartment() {	
	Department dept=new Department();
	
	String dept_name=JOptionPane.showInputDialog("Dept. Name: ","Type here ");
	int total_emp=Integer.parseInt(JOptionPane.showInputDialog("Enter Total Emp.: ","Type here"));
	String location=JOptionPane.showInputDialog("Enter Location","Type here");
	
	dept.setDeptName(dept_name);
	dept.setTotalemp(total_emp);
	dept.setLocation(location);
	
	depService.saveDepartment(dept);
	System.out.println("Department details saved!!");
	}
	
	//To check department details by using id
	public static void getDepartment()throws GlobalException
	{
		int id =Integer.parseInt(JOptionPane.showInputDialog("Enter Id to Search: ","Type here.."));
	DepartmentDTO depart=depService.getDepartmentUsingId(id);
	System.out.println("Department Name: "+depart.getDeptName());
	System.out.println("Total Employee: "+depart.getTotalemp());
	System.out.println("Location: "+depart.getLocation());

	}
	
	
	//To update department details
	public static void updateDepartment()throws GlobalException
	{
		Department dept1=new Department();

		String dept_name=JOptionPane.showInputDialog("Dept. Name: ","Type here ");
		int total_emp=Integer.parseInt(JOptionPane.showInputDialog("Enter Total Emp.: ","Type here"));
		String location=JOptionPane.showInputDialog("Enter Location","Type here");
		
		dept1.setDeptName(dept_name);
		dept1.setTotalemp(total_emp);
		dept1.setLocation(location);
		
		depService.updateDepartment(Integer.parseInt(JOptionPane.showInputDialog("Enter id to update: ","Type here....")),dept1);
		System.out.println("Department details updated successfully!!!!");
	
	}
	//To assign department to employee
	public static void assign()
	{
		int deptId=Integer.parseInt(JOptionPane.showInputDialog("Enter Dept.Id: ","Type here"));
		int empId=Integer.parseInt(JOptionPane.showInputDialog("Enter Employee Id: ","Type here"));
	depService.assignEmployeeToDept(empId, deptId);

	JOptionPane.showMessageDialog(null,"Employee has been assigned successfully!!");
	
	}
	
	
	//To delete department details
	public static void deleteDepartment()
	{
		int id=Integer.parseInt(JOptionPane.showInputDialog("Enter id to delete","Type here"));
	depService.deleteDepartmentById(id);
	JOptionPane.showMessageDialog(null,"Object is deleted!!!");
	}
	
	//To assign department to manager
	public static void assignmanager()
	{
		int deptId=Integer.parseInt(JOptionPane.showInputDialog("Enter Dept.Id: ","Type here"));
	int managId=Integer.parseInt(JOptionPane.showInputDialog("Enter Manager Id: ","Type here"));
	depService.assignManagerToDept(managId, deptId);
	JOptionPane.showMessageDialog(null,"Manager has been assigned successfully!!");
	}
	}

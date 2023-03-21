package com.ems;
import java.util.Scanner;
import javax.swing.JOptionPane;
import com.ems.Service.AdminService;
import com.ems.Service.EmployeeService;
import com.ems.Service.ManagerService;
import com.ems.ServiceImpl.AdminServiceImpl;
import com.ems.ServiceImpl.EmployeeServiceImpl;
import com.ems.ServiceImpl.ManagerServiceImpl;

public class App 
{
	static AdminService adminService=new AdminServiceImpl();
	static EmployeeService empService=new EmployeeServiceImpl();
	static ManagerService managService=new ManagerServiceImpl();
	static Scanner sc=new Scanner(System.in);
    public static void main( String[] args )
    {
    	mainMenu();
    }
    
    //Starting menu/main menu for employee management system
    	public static void mainMenu() {
    		System.out.println();
    		
    		int ch;
        	do {
            System.out.println( "**********Welcome to Employee Management System!************" );
            System.out.println("1) Admin\n2) Employee & Department\n3) Manager\n4) Exit");
            System.out.println("*************************************************************");
         //    ch =sc.nextInt();
            ch=Integer.parseInt(JOptionPane.showInputDialog("Enter Choice: ","Type here"));
            switch(ch)	
            {
            case 1:mainAdmin();//switch to admin menu
            	break;
            case 2:
            	mainUser();//switch to Employee menu
            	break;
            case 3:
            	mainManager();//switch to manager menu
            	break;
            case 4:
            	System.exit(0);//exit from employee management system
            	break;				
            default:
            	System.out.println("Wrong Input!!");	
            }
        	} while(ch!=3);
    	}
    	//Menu of Employee before login 
	public static void mainUser()
    {
		do {
    	System.out.println("***********Employee Menu********");
    	System.out.println("A) Login");
    	System.out.println("B) Exit");
        System.out.println("****************************");
    	//char Choice =sc.next().charAt(0);
    	String Choice = JOptionPane.showInputDialog("Enter Choice: ","Type here");
    	switch(Choice)
    	{
    	case"A":
    		boolean status=empService.login(JOptionPane.showInputDialog("Enter Username: ","Type here"),JOptionPane.showInputDialog("Enter Password: ","Type here"));
    		if(status==true)
    		{
    			EmployeeCRUD.afterLoginEmployee();
    		}
    		else
    		{
    			JOptionPane.showMessageDialog(null,"Wrong credentials");
    		}
    	break;
    	case "B":
    		mainMenu();//we can switch to mainmenu
    		break;
    	}
		}
    while(true);
   
		}
	//Menu for manager before login
	public static void mainManager() {
		
		do {
	    	System.out.println("***********Manager Menu********");

	    	System.out.println("A) Login");
	    	System.out.println("B) Exit");
	        System.out.println("****************************");

	        String Choice = JOptionPane.showInputDialog("Enter Choice: ","Type here");
	    	switch(Choice)
	    	{
	    
	    	case"A":
	    		boolean status=managService.login(JOptionPane.showInputDialog("Enter Username: ","Type here"),JOptionPane.showInputDialog("Enter Password: ","Type here"));
	    		if(status==true)
	    		{
	    			ManagerCRUD.afterLoginManager();
	    		}
	    		else
	    		{
	    			JOptionPane.showMessageDialog(null,"Wrong credentials");
	    		}
	    	break;
	    	case "B":
	    		mainMenu();
	    		break;
	    	}
	    	
	    	}while (true);
		}
	
	//Admin section menu before login
	public static void mainAdmin() {
		
	System.out.println("********Admin Menu***********");
	System.out.println("A) Login\nB) Exit");
	String choice=JOptionPane.showInputDialog("Enter choice","Type here");
	switch(choice)
	{

	case "A":
		boolean status=adminService.login(JOptionPane.showInputDialog("Enter Username: ","Type here"),JOptionPane.showInputDialog("Enter Password: ","Type here"));
		if(status==true)
		{
			AdminCRUD.afterLoginAdmin();
		}
		else
		{
			JOptionPane.showMessageDialog(null,"Wrong credentials");
		}
	break;
	case "B":
		mainMenu();
		break;
	}
	}
}
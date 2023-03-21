package com.ems;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.ems.Service.EmployeeService;
import com.ems.ServiceImpl.EmployeeServiceImpl;
import com.ems.config.Hibernateutil;
import com.ems.entity.Employee;
import com.ems.exception.GlobalException;
import com.ems.model.EmployeeDTO;

class EmployeeServiceTest {
EmployeeService empService=new EmployeeServiceImpl();
private static SessionFactory sessionFactory;
private Session session;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	sessionFactory=Hibernateutil.getSessionFactory();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	if(sessionFactory!=null)
		sessionFactory.close();
	System.out.println("Session Factory closed!!!");
	}

	@BeforeEach
	void setUp() throws Exception {
		session=sessionFactory.openSession();
	}

	@AfterEach
	void tearDown() throws Exception {
		if(session!=null)
			session.close();
		System.out.println("Session closed!!!");
	}

	/*@Test
	@DisplayName("Testing for save Employee")
	@Order(1)
	void testSaveEmployee() {
		Transaction tx=session.beginTransaction();
		Employee emp=Employee.builder().empName("Ritika").empAddress("Jaipur")
				.salary(30000).contact("9876543216").designation("PHP Developer").email("ritika@gmail.com")
				.dOJ(LocalDate.parse("2024-09-07")).build();
		empService.saveEmployee(emp);
		tx.commit();
		assertEquals("Ritika",emp.getEmpName());
	}
	*/
	@Test
	@DisplayName("Test for getting employee details by using ID")
	@Order(2)
		void testgetEmployeeUsingId() {
			EmployeeDTO eDTO=empService.getEmployeeUsingId(2);
		assertThat(eDTO.getEmpName()).isEqualTo("Pritam");
		}
		@Test
		@DisplayName("Test for updating an employee details")
		@Order(3)
	void testUpdateEmployee()
	{
		Employee emp=new Employee();
		emp.setEmpName("Rikita Singh");
		emp.setEmpAddress("Ranchi");//method to assign employee to manager
		emp.setSalary(54000);
		emp.setContact("9878967564");
		emp.setDesignation("Backend Developer");
		emp.setEmail("ritika12@gmail.com");
		emp.setDOJ(LocalDate.parse("2023-06-05"));
		emp.setUsername("rit123");
		emp.setPassword("12334");
		emp.setRole("employee");
		
		EmployeeDTO eDTO=empService.updateEmployee(6, emp);
		assertEquals("Ritika Singh",eDTO.getEmpName());
		}
//		@Test
//		@Order(4)
//		void testDeleteEmployee()
//		{
//			empService.deleteEmployeeById(6);
//			assertThrows(GlobalException.class,()->empService.getEmployeeUsingId(6));
//		}
		
	}



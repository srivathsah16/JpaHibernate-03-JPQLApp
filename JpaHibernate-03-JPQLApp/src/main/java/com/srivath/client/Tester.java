package com.srivath.client;

import java.util.List;

import com.srivath.dao.EmployeeDAO;
import com.srivath.dao.impl.EmployeeDaoImpl;
import com.srivath.entity.EmployeeEntity;

public class Tester {
	public static void main(String[] args) {
		EmployeeDAO dao = new EmployeeDaoImpl();

		/*
		 * create an employee record in db
		 */
//		EmployeeEntity emp = new EmployeeEntity(508, "Suresh", 6300.0, 3);
//		dao.saveEmployee(emp);

		/*
		 * retrive employee by ID
		 */
//		EmployeeEntity emp1 = dao.retrieveEmployee(787);
//		System.out.println(emp1);

		/*
		 * update employee record
		 */
//		EmployeeEntity emp2 = dao.updateEmployee(787, 9000.0);
//		System.out.println(emp2);

		/*
		 * delete employee record
		 */
//		dao.deleteEmployee(655);

		/*
		 * fetchEmployeeById()
		 */
//		System.out.println(dao.fetchEmployeeById(787));

		/*
		 * fetchEmployees()
		 */
//		List<EmployeeEntity> empList = dao.fetchEmployees();
//		empList.stream().forEach(System.out::println);
//		System.out.println("Employees whose salary > 8000");
//		empList.stream().filter(emp -> emp.getEmpSalary()>8000).forEach(System.out::println);

		/*
		 * fetchNameAndSalaries()
		 */
		List<Object[]> nameList = dao.fetchNameAndSalaries();
		nameList.stream().forEach(obj -> {
			System.out.println("name=" + obj[0] + ", salary=" + obj[1]);
		});

	}
}

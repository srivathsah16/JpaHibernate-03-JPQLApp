package com.srivath.dao;

import java.util.List;

import com.srivath.entity.EmployeeEntity;

public interface EmployeeDAO {
	void saveEmployee(EmployeeEntity employee);

	EmployeeEntity retrieveEmployee(Integer empId);

	EmployeeEntity updateEmployee(Integer empId, Double new_salary);
	
	void deleteEmployee(Integer empId);

	EmployeeEntity fetchEmployeeById(Integer empId);

	List<EmployeeEntity> fetchEmployees();

	List<Object[]> fetchNameAndSalaries();
}

package com.srivath.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.srivath.contants.AppContants;
import com.srivath.dao.EmployeeDAO;
import com.srivath.entity.EmployeeEntity;

public class EmployeeDaoImpl implements EmployeeDAO {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("test");

	@Override
	public void saveEmployee(EmployeeEntity employee) {
		EntityManager entityManager = factory.createEntityManager();
		EntityTransaction txn = entityManager.getTransaction();
		txn.begin();
		try {
			entityManager.persist(employee);
			txn.commit();
			System.out.println("Employee persisted in db..");
		} catch (Exception e) {
			txn.rollback();
			System.out.println("Error while persisting emp in db..");
		} finally {
			entityManager.close();
		}
	}

	@Override
	public EmployeeEntity retrieveEmployee(Integer empId) {
		EntityManager entityManager = factory.createEntityManager();
		EmployeeEntity emp = entityManager.find(EmployeeEntity.class, empId);
		entityManager.close();
		return emp;
	}

	@Override
	public EmployeeEntity updateEmployee(Integer empId, Double new_salary) {
		EntityManager entityManager = factory.createEntityManager();
		EmployeeEntity employee = entityManager.find(EmployeeEntity.class, empId);
		EntityTransaction txn = entityManager.getTransaction();
		txn.begin();
		employee.setEmpSalary(new_salary);
		txn.commit();
		System.out.println("Employee updated..");
		entityManager.close();
		return employee;
	}

	@Override
	public void deleteEmployee(Integer empId) {
		EntityManager entityManager = factory.createEntityManager();
		EmployeeEntity employee = entityManager.find(EmployeeEntity.class, empId);
		EntityTransaction txn = entityManager.getTransaction();
		txn.begin();
		try {
			entityManager.remove(employee);
			txn.commit();
			System.out.println("Employee deleted from db..");
		} catch (Exception e) {
			txn.rollback();
			System.out.println("Error while deleting employee from db..");
		} finally {
			entityManager.close();
		}
	}

	@Override
	public EmployeeEntity fetchEmployeeById(Integer empId) {
		EntityManager entityManager = factory.createEntityManager();
		TypedQuery<EmployeeEntity> query = entityManager.createQuery(AppContants.JPQL_QUERY1, EmployeeEntity.class);
		query.setParameter(1, empId);
		EmployeeEntity employee = query.getSingleResult();
		entityManager.close();
		return employee;
	}

	@Override
	public List<EmployeeEntity> fetchEmployees() {
		EntityManager entityManager = factory.createEntityManager();
		TypedQuery<EmployeeEntity> query = entityManager.createQuery(AppContants.JPQL_QUERY2, EmployeeEntity.class);
		List<EmployeeEntity> empList = query.getResultList();
		entityManager.close();
		return empList;
	}

	@Override
	public List<Object[]> fetchNameAndSalaries() {
		EntityManager entityManager = factory.createEntityManager();
		TypedQuery<Object[]> query = entityManager.createQuery(AppContants.JPQL_QUERY3, Object[].class);
		List<Object[]> nameSalaryList = query.getResultList();
		entityManager.close();
		return nameSalaryList;
	}
}

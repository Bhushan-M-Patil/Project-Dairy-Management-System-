package com.app.service;

import java.util.List;

import com.app.entities.Employee;

public interface EmployeeService {
//get all emps
	List<Employee> getAllEmpDetails();

	Employee addEmpDetails(Employee transientEmp);

	String deleteEmpDetails(Long empId);

	Employee fetchEmpDetails(Long empId);

	Employee updateEmpDetails(Employee detachedEmp);

//	EmployeeSpecificResp authenticateEmp(LoginRequestDto dto);
//
//	List<Employee> getEmpsByDateAndDept(LocalDate joinDate1, String dept1);
//
//	List<EmployeeResponse> getEmpsBySalary(double minSal, double maxSal);
//
//	List<Employee> getEmpsByLastNameContainingKey(String key);
//
//	String applySalaryIncrement(EmpSalIncrementRequest dto);
}

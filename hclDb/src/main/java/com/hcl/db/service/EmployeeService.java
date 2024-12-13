package com.hcl.db.service;

import java.util.List;

import com.hcl.db.entity.Employee;

public interface EmployeeService {

	public List<Employee> getEmployee();

	public Employee save(Employee em);

	public String update(Employee em, Long id);

	Employee getEmployeeById(Long id);

	public String deleteEmployeeById(Long id);

}

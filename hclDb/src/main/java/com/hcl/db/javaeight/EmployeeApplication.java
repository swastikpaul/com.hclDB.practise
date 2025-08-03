package com.hcl.db.javaeight;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeApplication {

	/*
	 * Emp obj. ---------- name age dept sal gender Q1. avg sal of each dept Q2.
	 * count of male and female of employee in each dept Q3. get max age of
	 * employee.
	 */
	public static void main(String[] args) {

		List<Employee> empList = Stream.of(new Employee("Vishwanath", 38, "IT", 2000, "Male"),
				new Employee("Sachin", 40, "Sports", 4000, "Male"), new Employee("Neha", 30, "IT", 1000, "Female"),
				new Employee("Rekha", 28, "Sports", 3000, "Female"),
				new Employee("Jaya", 20, "Electric", 6000, "Female"),
				new Employee("Riya", 18, "Sports", 8000, "Female")).collect(Collectors.toList());

		Map<String, Map<String, Long>> empGen = empList.stream().collect(Collectors.groupingBy(Employee::getDepartment,
				Collectors.groupingBy(Employee::getGender, Collectors.counting())));

		Map<String, Double> empSal = empList.stream().collect(
				Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));

		Employee maxAgeEmp1 = empList.stream().max(Comparator.comparingInt(Employee::getAge)).get();
		// int maxAgeEmp2 =
		// empList.stream().mapToInt(Employee::getAge).max().getAsInt();

		// System.out.println(empGen);
		// System.out.println(empSal);
		System.out.println(maxAgeEmp1);
	}

}

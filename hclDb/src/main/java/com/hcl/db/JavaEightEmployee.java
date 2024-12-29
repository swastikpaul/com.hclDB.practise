package com.hcl.db;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaEightEmployee {

	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		List<Employee> empList = Stream.of(
				new Employee(90, "vishwanath", "HCL", "PUNE", 900000, Arrays.asList(122345, 567890), 45, "M"),
				new Employee(40, "Kamla", "INFO", "Bangalore", 500000, Arrays.asList(155545, 567897), 56, "M"),
				new Employee(70, "Rahul", "CSC", "Delhi", 100000, Arrays.asList(112345, 237890), 34, "F"),
				new Employee(100, "Anil", "Cognizent", "Bombay", 400000, Arrays.asList(120045, 565590), 67, "F"),
				new Employee(20, "Sourabh", "LTI", "Kolkata", 600000, Arrays.asList(188885, 522290), 66, "F"),
				new Employee(30, "Vikas", "Accesnture", "Delhi", 700000, Arrays.asList(122666, 567111), 23, "F"))
				.collect(Collectors.toList());

		// find the list of employee whose salary between 1LPA to 5LPA
		List<Employee> e1 = empList.stream().filter(s -> s.getSalary() >= 100000 && s.getSalary() <= 500000)
				.collect(Collectors.toList());
		// System.out.println(e1);

		// find the list of employee whose salary between 1LPA to 5LPA then sort them by
		// their name (ascending & descending)
		List<Employee> e2 = empList.stream().filter(s -> s.getSalary() >= 100000 && s.getSalary() <= 500000)
				.sorted(Comparator.comparing(Employee::getName, Comparator.reverseOrder()))
				.collect(Collectors.toList());
		// System.out.println(e2);

		// find all the city name as list
		List<String> e3 = empList.stream().map(Employee::getAddress).sorted().collect(Collectors.toList());

		List<String> avoidDuplicateCity1 = empList.stream().map(Employee::getAddress).sorted().distinct()
				.collect(Collectors.toList());

		Set<String> avoidDuplicateCity2 = empList.stream().map(Employee::getAddress).sorted()
				.collect(Collectors.toSet());

		// System.out.println(avoidDuplicateCity2);

		// find all contact number
		// one2one = use map
		// one2Many = use flatMap
		List<List<Integer>> contListOfList = empList.stream().map(Employee::getMobNum).collect(Collectors.toList());
		List<Integer> contList = empList.stream().flatMap(fm -> fm.getMobNum().stream()).collect(Collectors.toList());
		// System.out.println(contList);

		// group student by city
		Map<String, List<Employee>> mapList1 = empList.stream().collect(Collectors.groupingBy(Employee::getAddress));

		Map<String, Long> mapList2 = empList.stream()
				.collect(Collectors.groupingBy(Employee::getAddress, Collectors.counting()));

		Map<String, List<String>> mapList3 = empList.stream().collect(Collectors.groupingBy(Employee::getAddress,
				Collectors.mapping(Employee::getName, Collectors.toList())));
		// System.out.println(mapList3);

		// find the average age of male and female employee
		Map<String, Double> avg = empList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getAge)));
		// System.out.println(avg);

		// find employ object which company providing highest salary
		Map<String, Optional<Employee>> mapBasedonSal = empList.stream().collect(Collectors
				.groupingBy(Employee::getCompany, Collectors.maxBy(Comparator.comparing(Employee::getSalary))));
		// System.out.println(mapBasedonSal);

		// find the second highest salary
		List<Employee> sortBySalary = empList.stream().sorted(Comparator.comparing(Employee::getSalary))
				.collect(Collectors.toList());
		Employee secondHighestSalary = empList.stream().sorted(Comparator.comparing(Employee::getSalary).reversed())
				.skip(1).findFirst().get();
		System.out.println(secondHighestSalary);
	}

	public static class Employee {

		private Integer id;
		private String name;
		private String company;
		private String address;
		private Integer salary;
		private List<Integer> mobNum;
		private Integer age;
		private String gender;

		public Employee(Integer id, String name, String company, String address, Integer salary, List<Integer> mobNum,
				Integer age, String gender) {
			this.id = id;
			this.name = name;
			this.company = company;
			this.address = address;
			this.salary = salary;
			this.mobNum = mobNum;
			this.age = age;
			this.gender = gender;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getCompany() {
			return company;
		}

		public void setCompany(String company) {
			this.company = company;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public Integer getSalary() {
			return salary;
		}

		public void setSalary(Integer salary) {
			this.salary = salary;
		}

		public List<Integer> getMobNum() {
			return mobNum;
		}

		public void setMobNum(List<Integer> mobNum) {
			this.mobNum = mobNum;
		}

		public Integer getAge() {
			return age;
		}

		public void setAge(Integer age) {
			this.age = age;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		@Override
		public String toString() {
			return "Employee [id=" + id + ", name=" + name + ", company=" + company + ", address=" + address
					+ ", salary=" + salary + ", mobNum=" + mobNum + ", age=" + age + ", gender=" + gender + "]";
		}

	}
}

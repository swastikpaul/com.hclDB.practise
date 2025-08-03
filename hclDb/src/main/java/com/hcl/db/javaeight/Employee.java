package com.hcl.db.javaeight;

public class Employee {

	private String name;
	private Integer age;
	private String department;
	private Integer salary;
	private String gender;

	public Employee(String name, Integer age, String department, Integer salary, String gender) {
		this.name = name;
		this.age = age;
		this.department = department;
		this.salary = salary;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", department=" + department + ", salary=" + salary
				+ ", gender=" + gender + "]";
	}

}

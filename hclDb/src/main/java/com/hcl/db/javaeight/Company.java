package com.hcl.db.javaeight;

import java.util.Date;

public class Company {

	private String name;
	private Integer age;
	private Boolean isManager;
	private String department;
	private Date doj;

	public Company(String name, Integer age, Boolean isManager, String department, Date doj) {
		this.name = name;
		this.age = age;
		this.isManager = isManager;
		this.department = department;
		this.doj = doj;
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

	public Boolean getIsManager() {
		return isManager;
	}

	public void setIsManager(Boolean isManager) {
		this.isManager = isManager;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

	@Override
	public String toString() {
		return "Company [name=" + name + ", age=" + age + ", isManager=" + isManager + ", department=" + department
				+ ", doj=" + doj + "]";
	}

}

package com.hcl.db.javaeight;

import java.time.LocalDate;

public class Student {

	private int employeeId;
	private String name;
	private String title;
	private Long rollnumber;
	private LocalDate updated_date;

	public Student(int employeeId, String name, String title, Long rollnumber, LocalDate updated_date) {
		this.employeeId = employeeId;
		this.name = name;
		this.title = title;
		this.rollnumber = rollnumber;
		this.updated_date = updated_date;
	}

	public Student() {
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getRollnumber() {
		return rollnumber;
	}

	public void setRollnumber(Long rollnumber) {
		this.rollnumber = rollnumber;
	}

	public LocalDate getUpdated_date() {
		return updated_date;
	}

	public void setUpdated_date(LocalDate updated_date) {
		this.updated_date = updated_date;
	}

	@Override
	public String toString() {
		return "Student [employeeId=" + employeeId + ", name=" + name + ", title=" + title + ", rollnumber="
				+ rollnumber + ", updated_date=" + updated_date + "]";
	}

}

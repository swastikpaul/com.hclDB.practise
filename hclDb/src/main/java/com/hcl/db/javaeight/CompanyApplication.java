package com.hcl.db.javaeight;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CompanyApplication {

	/*
	 * 1) Partition object based on employee manager or not. 2) Based on department
	 * get employee object.
	 */
	public static void main(String[] args) {

		List<Company> company = Stream.of(new Company("Vish", 34, true, "Delivery", getDate("2020-01-15")),
				new Company("Pal", 38, false, "IT", getDate("2020-01-19")),
				new Company("Rama", 31, false, "R&D", getDate("2020-01-20")),
				new Company("Kamal", 33, true, "IT", getDate("2020-01-22")),
				new Company("Fiona", 24, true, "Delivery", getDate("2020-01-10"))).collect(Collectors.toList());

		// LocalDate date = LocalDate.parse("2020-01-15",
		// DateTimeFormatter.ofPattern("yyyy-MM-dd"));

		// Partition object based on employee is manager or not and return Company
		// object.
		Map<Boolean, List<Company>> isManagerMap = company.stream()
				.collect(Collectors.partitioningBy(f -> f.getIsManager() == true));

		// Partition object based on employee is manager or not and return employee's
		// name.
		Map<Boolean, List<String>> isManagerNameMap = company.stream().collect(Collectors.partitioningBy(
				f -> f.getIsManager() == true, Collectors.mapping(Company::getName, Collectors.toList())));

		// Based on department return employee object.
		Map<String, List<Company>> depMap = company.stream()
				.collect(Collectors.groupingBy(Company::getDepartment, Collectors.toList()));

		// Based on department return name of employee list.
		Map<String, List<String>> depEmplNameMap = company.stream().collect(Collectors
				.groupingBy(Company::getDepartment, Collectors.mapping(Company::getName, Collectors.toList())));

		// System.out.println(isManagerNameMap);
		System.out.println(depMap);
	}

	private static Date getDate(String date) {
		String[] strArr = date.split("-");
		Date d = new Date();
		d.setYear(Integer.parseInt(strArr[0]));
		d.setMonth(Integer.parseInt(strArr[1]));
		d.setDate(Integer.parseInt(strArr[2]));
		return d;
	}
}

package com.hcl.db.javaeight;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.hcl.db.date.DateUtil;

public class StudentApplication {

	/*
	 * 1) Get unique employee object based on id (employee id is duplicate) and 2)
	 * sort them based on date. Latest date should come first.
	 */
	public static void main(String[] args) {
		List<Student> stdtList = Stream.of(
				new Student(4, "vish", "Mr", 123L, DateUtil.convertStringToLocalDate("2020-01-11", "yyyy-MM-dd")),
				new Student(8, "paul", "Mr", 456L, DateUtil.convertStringToLocalDate("2020-01-15", "yyyy-MM-dd")),
				new Student(4, "rashi", "Miss", 678L, DateUtil.convertStringToLocalDate("2020-01-20", "yyyy-MM-dd")),
				new Student(7, "kamal", "Mr", 234L, DateUtil.convertStringToLocalDate("2020-01-22", "yyyy-MM-dd")),
				new Student(5, "ram", "Mr", 890L, DateUtil.convertStringToLocalDate("2020-01-10", "yyyy-MM-dd")))
				.collect(Collectors.toList());

		List<Optional<Student>> list = stdtList.stream()
				.collect(Collectors.groupingBy(Student::getEmployeeId,
						Collectors.maxBy(Comparator.comparingInt(Student::getEmployeeId))))
				.entrySet().stream().filter(f -> !f.getValue().isEmpty()).map(Map.Entry::getValue)
				.collect(Collectors.toList());

		List<Student> stdList = new ArrayList<>();
		list.forEach(std -> {
			Integer id = std.get().getEmployeeId();
			String name = std.get().getName();
			String title = std.get().getTitle();
			long rollNum = std.get().getRollnumber();
			LocalDate date = std.get().getUpdated_date();
			Student student = new Student(id, name, title, rollNum, date);
			stdList.add(student);
		});

		List<Student> sortList = stdList.stream()
				.sorted(Comparator.comparingInt(s -> convertLocalDateToInteger(s.getUpdated_date())))
				.collect(Collectors.toList());
		System.out.println(sortList);
	}

	private static Integer convertLocalDateToInteger(LocalDate date) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd");
		return Integer.parseInt(date.format(dtf));
	}

}

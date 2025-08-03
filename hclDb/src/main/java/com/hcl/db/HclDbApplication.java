package com.hcl.db;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableDiscoveryClient
public class HclDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(HclDbApplication.class, args);
		System.out.println("*****************************");

		// LocalDate ld = DateUtil.convertStringToLocalDate("2020-01-15", "yyyy-MM-dd");
		// Date d = new Date("2020-07-17");
		// String s = DateUtil.convertDateToString(d);
		// System.out.println(s);
	}

}

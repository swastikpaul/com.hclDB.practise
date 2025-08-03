package com.hcl.db.javaeight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PersonAddressApplication {

	// Find the list of all persons whose name contain "SACHIN" and age is greater
	// or equals to 24 and whose address in city "Delhi"
	public static void main(String[] args) {

		List<Person> personList = Arrays.asList(
				new Person("SACHIN TENDULKAR", 40, "MALE",
						Arrays.asList(new Address("a20", "Hyderabad", "503001"),
								new Address("a21", "Delhi", "503002"))),
				new Person("MS DHONI", 36, "MALE",
						Arrays.asList(new Address("a22", "Mumbai", "50300"), new Address("a23", "Meerut", "503001"))),
				new Person("SURESH RAINA", 32, "MALE",
						Arrays.asList(new Address("a24", "Ghaziabad", "503001"),
								new Address("a25", "Gurgaon", "503001"))),
				new Person("SACHIN JHOSHI", 24, "MALE",
						Arrays.asList(new Address("a26", "Bangalore", "503001"),
								new Address("a27", "Hyderabad", "503001"))),
				new Person("SACHIN verma", 40, "MALE", Arrays.asList(new Address("a28", "Bangalore", "560037"),
						new Address("a29", "Delhi", "503001"))));

		List<Person> pList = new ArrayList<>();
		List<Address> addList = new ArrayList<>();

		List<Person> p1 = personList.stream().filter(f -> f.getName().contains("SACHIN") && f.getAge() >= 24)
				.collect(Collectors.toList());

		p1.forEach(person -> {
			String name = person.getName();
			String gender = person.getGender();
			Integer age = person.getAge();

			person.address.forEach(city -> {
				if (city.getCity().equals("Delhi")) {
					String id = city.getId();
					String cit = city.getCity();
					String zip = city.getZipcode();
					Address address = new Address(id, cit, zip);
					addList.add(address);
					Person per = new Person(name, age, gender, addList);
					pList.add(per);
				}
			});
		});
		System.out.println(pList);
	}

}

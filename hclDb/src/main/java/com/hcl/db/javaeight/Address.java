package com.hcl.db.javaeight;

public class Address {

	private String id;
	private String city;
	private String zipcode;

	public Address(String id, String city, String zipcode) {
		this.id = id;
		this.city = city;
		this.zipcode = zipcode;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", city=" + city + ", zipcode=" + zipcode + "]";
	}

}

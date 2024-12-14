package com.hcl.db.entity;

public class Company {

	private Integer id;
	private String cName;
	private String sector;
	private Integer since;
	private Long numberOfEmployee;
	private String location;

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public Integer getSince() {
		return since;
	}

	public void setSince(Integer since) {
		this.since = since;
	}

	public Long getNumberOfEmployee() {
		return numberOfEmployee;
	}

	public void setNumberOfEmployee(Long numberOfEmployee) {
		this.numberOfEmployee = numberOfEmployee;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", cName=" + cName + ", sector=" + sector + ", since=" + since
				+ ", numberOfEmployee=" + numberOfEmployee + ", location=" + location + "]";
	}

}

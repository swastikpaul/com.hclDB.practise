package com.hcl.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hcl.db.entity.Employee;

public class EmployeeRowMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee em = new Employee();
		em.setName(rs.getString("NAME"));
		em.setGender(rs.getString("GENDER"));
		em.setAge(rs.getInt("AGE"));
		em.setDob(rs.getDate("DOB"));
		em.setSalary(rs.getLong("SALARY"));
		em.setAddress(rs.getString("ADDRESS"));
		return em;
	}

}

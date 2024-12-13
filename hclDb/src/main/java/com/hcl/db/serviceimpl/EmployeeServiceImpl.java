package com.hcl.db.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.hcl.db.entity.Employee;
import com.hcl.db.mapper.EmployeeRowMapper;
import com.hcl.db.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Employee> getEmployee() {
		String query = "select * from ao_db.employee";
		List<Employee> rs = jdbcTemplate.query(query, new EmployeeRowMapper());
		return rs;
	}

	@Override
	public Employee save(Employee em) {
		String query = "insert into ao_db.employee(name, gender, age, dob, salary, address) values(?,?,?,?,?,?)";
		int row = jdbcTemplate.update(query, em.getName(), em.getGender(), em.getAge(), em.getDob(), em.getSalary(),
				em.getAddress());
		System.out.println("Record inserted & number of row effected: " + row);
		// String lQObject = "SELECT * FROM ao_db.employee order by id desc limit 1";
		// Employee e = jdbcTemplate.queryForObject(lQObject, new EmployeeRowMapper());
		// System.out.println(e);
		return em;
	}

	@Override
	public String update(Employee em, Long id) {

		String query = "update ao_db.employee set name =?, gender =?, age =?, dob=?, salary =?, address =? where id =?";
		int row = jdbcTemplate.update(query, em.getName(), em.getGender(), em.getAge(), em.getDob(), em.getSalary(),
				em.getAddress(), id);
		System.out.println("Record updated & number of row effected: " + row);
		return "Record updated & number of row effected: " + row;
	}

	@Override
	public Employee getEmployeeById(Long id) {
		String query = "SELECT * FROM ao_db.employee where id = " + id;
		Employee em = jdbcTemplate.queryForObject(query, new EmployeeRowMapper());
		return em;
	}

	@Override
	public String deleteEmployeeById(Long id) {
		String query = "DELETE FROM ao_db.employee where id = ?";
		jdbcTemplate.update(query, id);
		return "Record delete with ID: " + id;
	}

}

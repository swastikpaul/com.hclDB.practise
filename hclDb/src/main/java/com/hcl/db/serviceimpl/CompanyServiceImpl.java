package com.hcl.db.serviceimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hcl.db.entity.Company;
import com.hcl.db.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	@Qualifier("dmds")
	private DataSource dataSource;

	Connection con = null;

	@Override
	public List<Company> getCompanies() throws SQLException {
		Company cy = null;
		List<Company> cyList = new ArrayList<>();
		String query = "select * from ao_db.company";
		try {
			con = dataSource.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				cy = new Company();
				cy.setId(rs.getInt("ID"));
				cy.setcName(rs.getString("C_NAME"));
				cy.setSector(rs.getString("SECTOR"));
				cy.setSince(rs.getInt("SINCE"));
				cy.setNumberOfEmployee(rs.getLong("NO_OF_EMPLOYEE"));
				cy.setLocation(rs.getString("LOCATION"));
				cyList.add(cy);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return cyList;
	}

	@Override
	public String save(Company cy) throws SQLException {
		String query = "insert into ao_db.company(ID, C_NAME, SECTOR, SINCE, NO_OF_EMPLOYEE, LOCATION) VALUES(?, ?, ?, ?, ?, ?)";
		try {
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, 0);
			ps.setString(2, cy.getcName());
			ps.setString(3, cy.getSector());
			ps.setInt(4, cy.getSince());
			ps.setLong(5, cy.getNumberOfEmployee());
			ps.setString(6, cy.getLocation());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return "Record inserted!";

	}

	@Override
	public String update(Company cy, Long id) throws SQLException {
		String query = "update ao_db.company set ID=?, C_NAME=?, SECTOR=?, SINCE=?, NO_OF_EMPLOYEE=?, LOCATION=? where id="
				+ id;
		try {
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(query);
			ps.setLong(1, id);
			ps.setString(2, cy.getcName());
			ps.setString(3, cy.getSector());
			ps.setInt(4, cy.getSince());
			ps.setLong(5, cy.getNumberOfEmployee());
			ps.setString(6, cy.getLocation());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}

		return "Record updated!";
	}

	@Override
	public Company getCompanyById(Long id) throws SQLException {
		Company cy = null;
		try {
			String query = "select * from ao_db.company where id=?";
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(query);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				cy = new Company();
				cy.setId(rs.getInt("ID"));
				cy.setcName(rs.getString("C_NAME"));
				cy.setSector(rs.getString("SECTOR"));
				cy.setSince(rs.getInt("SINCE"));
				cy.setNumberOfEmployee(rs.getLong("NO_OF_EMPLOYEE"));
				cy.setLocation(rs.getString("LOCATION"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return cy;
	}

	@Override
	public String deleteCompanyById(Long id) throws SQLException {
		try {
			String query = "delete from ao_db.company where id=?";
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(query);
			ps.setLong(1, id);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return "Record Deleted!";
	}

}

package com.hcl.db.service;

import java.sql.SQLException;
import java.util.List;

import com.hcl.db.entity.Company;

public interface CompanyService {

	public List<Company> getCompanies() throws SQLException;

	public String save(Company cy) throws SQLException;

	public String update(Company cy, Long id) throws SQLException;

	Company getCompanyById(Long id) throws SQLException;

	public String deleteCompanyById(Long id) throws SQLException;

}

package com.hcl.db.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.db.entity.Company;
import com.hcl.db.service.CompanyService;

@RequestMapping("/company")
@RestController
public class CompanyController {

	@Autowired
	private CompanyService companyService;

	@GetMapping("/all")
	public ResponseEntity<List<Company>> getCompany() throws SQLException {
		return ResponseEntity.ok(companyService.getCompanies());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Company> getCompanyById(@PathVariable Long id) throws SQLException {
		return ResponseEntity.ok(companyService.getCompanyById(id));
	}

	@PostMapping("/save")
	public ResponseEntity<String> saveCompany(@RequestBody Company cy) throws SQLException {
		return ResponseEntity.status(HttpStatus.CREATED).body(companyService.save(cy));
	}

	@PatchMapping("/edit/{id}")
	public ResponseEntity<String> updateCompany(@RequestBody Company em, @PathVariable Long id) throws SQLException {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(companyService.update(em, id));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCompanyById(@PathVariable Long id) throws SQLException {
		return ResponseEntity.ok(companyService.deleteCompanyById(id));
	}

}

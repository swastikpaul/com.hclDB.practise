package com.hcl.db.controller;

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

import com.hcl.db.entity.User;
import com.hcl.db.service.UserService;

@RequestMapping("/user")
@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/all")
	public ResponseEntity<List<User>> getUsers() {
		return ResponseEntity.ok(userService.getUser());
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> getUsersById(@PathVariable("id") Long id) {
		return ResponseEntity.ok(userService.getUserById(id));
	}

	@PostMapping("/save")
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
	}

	@PatchMapping("/edit/{id}")
	public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable("id") Long id) {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(userService.update(user, id));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUsersById(@PathVariable("id") Long id) {
		userService.deleteUserById(id);
		return ResponseEntity.ok("User deleted with ID: " + id);
	}
}

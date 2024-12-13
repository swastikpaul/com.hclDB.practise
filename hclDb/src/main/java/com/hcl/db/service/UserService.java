package com.hcl.db.service;

import java.util.List;

import com.hcl.db.entity.User;

public interface UserService {

	public List<User> getUser();

	public User save(User user);

	public User update(User user, Long id);

	User getUserById(Long id);

	public void deleteUserById(Long id);

}

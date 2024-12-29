package com.hcl.db.serviceimpl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.db.entity.User;
import com.hcl.db.service.UserService;
import com.hcl.db.service.UserServiceRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserServiceRepository userServiceRepository;

	@Override
	public List<User> getUser() {
		return userServiceRepository.findAll();
	}

	@Override
	public User getUserById(Long id) {
		User user = userServiceRepository.findById(id).get();
		if (Objects.isNull(user)) {
			throw new NoSuchElementException();
		}
		return user;
	}

	@Override
	public User save(User user) {
		return userServiceRepository.save(user);
	}

	@Override
	public User update(User user, Long id) {
		User userIdObj = getUserById(id);
		if (Objects.nonNull(userIdObj)) {
			userIdObj.setName(user.getName());
			userIdObj.setBirthDate(user.getBirthDate());
			userIdObj.setProfileDesc(user.getProfileDesc());
		}
		return userServiceRepository.save(userIdObj);
	}

	@Override
	public void deleteUserById(Long id) {
		User userIdObj = getUserById(id);
		if (Objects.nonNull(userIdObj)) {
			userServiceRepository.deleteById(id);
		}
	}

}

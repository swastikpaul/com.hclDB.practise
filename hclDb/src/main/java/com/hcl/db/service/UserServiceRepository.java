package com.hcl.db.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.db.entity.User;

@Repository
public interface UserServiceRepository extends JpaRepository<User, Long> {

}

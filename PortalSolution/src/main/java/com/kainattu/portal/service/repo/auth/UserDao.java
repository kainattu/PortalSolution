package com.kainattu.portal.service.repo.auth;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kainattu.portal.service.model.auth.DAOUser;

@Repository
public interface UserDao extends CrudRepository<DAOUser, Integer> {
	DAOUser findByUsername(String username);
}
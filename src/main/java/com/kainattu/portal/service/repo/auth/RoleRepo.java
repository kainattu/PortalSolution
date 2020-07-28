package com.kainattu.portal.service.repo.auth;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kainattu.portal.service.model.auth.DAORole;

public interface RoleRepo extends JpaRepository<DAORole, Long>{

	DAORole findByRole(String role);

}

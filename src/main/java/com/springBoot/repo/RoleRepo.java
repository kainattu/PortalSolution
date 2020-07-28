package com.springBoot.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springBoot.model.DAORole;

public interface RoleRepo extends JpaRepository<DAORole, Long>{

	DAORole findByRole(String role);

}

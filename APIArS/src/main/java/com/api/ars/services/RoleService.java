package com.api.ars.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.ars.entities.Role;
import com.api.ars.repositories.RoleRepository;

@Service
public class RoleService {
	
	@Autowired
	RoleRepository roleRepository;

	public Role save(Role role) {
		return roleRepository.save(role);
	}
}

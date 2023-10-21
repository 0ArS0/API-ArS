package com.api.ars.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.ars.entities.User;
import com.api.ars.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public User findByEmail(String email) {
		return userRepository.findByEmail(email).get();
	}

	public User save(User user) {
		return userRepository.save(user);
	}

	public List<User> listarTodos() {
		return userRepository.findAll();
	}

	public void remover(Integer id) {
		User user = userRepository.findById(id).get();
		userRepository.deleteById(id);
	}

}
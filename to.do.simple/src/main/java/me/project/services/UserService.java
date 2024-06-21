package me.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import me.project.models.User;
import me.project.repositories.UserRepository;

@Service
public class UserService {

	// ATTRIBUTES -----------------------------------
	private final UserRepository userRepository;

	// PRINCIPALS METHODS----------------------------
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public List<User> findAllUsers(){
		List<User> users = userRepository.findAll(Sort.by("name")); 
		return users;
	}
	public User findUserById(Long id) {
		return userRepository.findById(id).orElse(null);
	}
	public User saveOrUpdate(User user) {
		return userRepository.save(user);
	}
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}
	public void deleteAllUsers() {
		userRepository.deleteAll();
	}
	
	// ACCESS METHODS -------------------------------
}

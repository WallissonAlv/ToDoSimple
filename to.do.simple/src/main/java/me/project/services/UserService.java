package me.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import me.project.exceptions.UserNotFoundException;
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
		Optional<User> user = userRepository.findById(id);
		if(user.isPresent()) {
			return user.get();
		} else {
			throw new UserNotFoundException("User with id "+ id +" not found");
		}
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

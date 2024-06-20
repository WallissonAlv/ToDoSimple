package me.project.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.project.models.User;
import me.project.repositories.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {

	// ATTRIBUTES -----------------------------------
	@Autowired
	private UserRepository userRepository;
	
	// PRINCIPALS METHODS ---------------------------
	@GetMapping // Get all users of database
	public ResponseEntity <List<User>> getAllUsers(){
		List<User> users = userRepository.findAll();
		if(users.isEmpty()) {
			return ResponseEntity
					.noContent()
					.build();
		}else {
			return ResponseEntity.ok(users);
		}
	}
	
	@GetMapping("/{id}") // Find an user by id number
	public ResponseEntity<User> getUserById(@PathVariable Long id){
		Optional<User> user = userRepository.findById(id);
		if(user.isPresent()) {
			return ResponseEntity.ok(user.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user){
		User savedUser = userRepository.save(user);
		return ResponseEntity.ok(savedUser);
	}
	
	// ACCESS METHOD --------------------------------
}

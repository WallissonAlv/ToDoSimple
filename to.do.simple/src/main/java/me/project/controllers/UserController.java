package me.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.project.models.User;
import me.project.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	// ATTRIBUTES -----------------------------------
	@Autowired
	private UserService userService;
	
	// PRINCIPALS METHODS ---------------------------
	@GetMapping // Find all users of database
	public ResponseEntity <List<User>> findAllUsers(){
		List<User> users = userService.findAllUsers();
		if(users.isEmpty()) {
			return ResponseEntity
					.noContent()
					.build();
		}else {
			return ResponseEntity.ok(users);
		}
	}
	@GetMapping("/{id}") // Find an user by id number
	public ResponseEntity<User> findUserById(@PathVariable Long id){
		User user = userService.findUserById(id);
		return ResponseEntity.ok(user);
	}
	@PostMapping // Create a new user
	public ResponseEntity<User> createUser(@RequestBody User user){
		User savedUser = userService.saveOrUpdate(user);
		return ResponseEntity.ok(savedUser);
	}
	@PutMapping("/{id}") // Update user's data
	public ResponseEntity<User> updateUser(@RequestBody User user){
		User updatedUser = userService.saveOrUpdate(user);
		return ResponseEntity.ok(updatedUser);
	}
	@DeleteMapping
	public void deleteUser(Long id) {
		userService.deleteUser(id);
		ResponseEntity.ok(id);
	}
	
	// ACCESS METHOD --------------------------------
}

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

import me.project.models.Todo;
import me.project.services.TodoService;

@RestController
@RequestMapping("/todos")
public class TodoController {

	// ATTRIBUTES -----------------------------------
	@Autowired
	private TodoService todoService;
		
	// PRINCIPALS METHODS ---------------------------
	@GetMapping //Find all todos of database 
	public ResponseEntity<List<Todo>> findAllTodos(){
		List<Todo> allTodo = todoService.findAllTodos();
		if(allTodo.isEmpty()) {
			return ResponseEntity
						.noContent()
						.build();
		} else {
			return ResponseEntity.ok(allTodo);
		}
	}
	@GetMapping("/{id}") //Find a todo by Id 
	public ResponseEntity<Todo> findTodoById(@PathVariable Long id) {
		Todo todo = todoService.findTodoById(id);
		return ResponseEntity.ok(todo);
	}
	@PostMapping //Create a new To do 
	public ResponseEntity<Todo> createTodo(@RequestBody Todo todo){
		Todo savedTodo = todoService.saveOrUpdate(todo);
		return ResponseEntity.ok(savedTodo);
	}
	@PutMapping //Update Todo's Data
	public ResponseEntity<Todo> updateTodo(@RequestBody Todo todo){
		Todo updatedTodo = todoService.saveOrUpdate(todo);
		return ResponseEntity.ok(updatedTodo);
	}
	@DeleteMapping("/{id}") //Delete a Todo
	public void deleteTodoById(Long id) {
		todoService.deleteTodo(id);
		ResponseEntity.ok(id);
	}
	@DeleteMapping // Clear all Todos
	public void clearTodos() {
		todoService.clearAllTodos();
		todoService.findAllTodos();
	}
}

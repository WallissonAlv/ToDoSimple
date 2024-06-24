package me.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import me.project.exceptions.TodoNotFoundException;
import me.project.models.Todo;
import me.project.repositories.TodoRepository;

@Service
public class TodoService {

	// ATTRIBUTES -----------------------------------
	private final TodoRepository todoRepository;
	
	// PRINCIPALS METHODS----------------------------
	@Autowired
	public TodoService (TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}
	
	public List<Todo> findAllTodos(){
		List<Todo> todo = todoRepository.findAll(Sort.by("priority").and(Sort.by("title")));
		return todo;
	}
	public Todo findTodoById(Long id) {
		Optional<Todo> todo = todoRepository.findById(id);
		if(todo.isPresent()) {
			return todo.get();
		} else {
			throw new TodoNotFoundException ("Todo with id "+ id +" not found");
		}
	}
	public Todo saveOrUpdate(Todo todo) {
		return todoRepository.save(todo);
	}
	public void deleteTodo(Long id) {
		todoRepository.deleteById(id);
	}
	public void clearAllTodos() {
		todoRepository.deleteAll();
	}
	
	// ACCESS METHODS -------------------------------
	
}

package me.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

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
		List<Todo> todo = todoRepository.findAll(Sort.by("priority").and(Sort.by("name")));
		return todo;
	}
	public Todo findTodoById(Long id) {
		return todoRepository.findById(id).orElse(null);
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

package com.rajakumar.sample.api;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rajakumar.sample.model.Todo;
import com.rajakumar.sample.services.TodoService;
@RequestMapping("api/v1/todo")
@RestController
public class TodoController {
	@Autowired
	private TodoService todoService;
	@CrossOrigin
	@PostMapping("/add")
	public Todo addTodo(@RequestBody Todo todo) {
		logPrint("IN method add todo...");
		System.out.println(todo);
		return todoService.addTodo(todo.getTitle(), todo.getDescription());
	}
	@CrossOrigin
	@GetMapping
	public List<Todo> selectAllTodos(){
		logPrint("IN method list all todo...");
		return todoService.selectAllTodos();
	}
	@CrossOrigin
	@PostMapping("/completed")
	public Todo updateCompletedTodo(@RequestBody Todo todo) {
		return todoService.updateCompletedTodo(todo.getId());
		
	}
	public void logPrint(String str) {
		System.out.println(str);
	}
}

package com.rajakumar.sample.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rajakumar.sample.dao.TodoRepository;
import com.rajakumar.sample.model.Todo;
@Service
public class TodoService {
	@Autowired
	private TodoRepository todoRepository;
	public Todo addTodo(String title,String description) {
		Todo todo = new Todo(title, description);
		todoRepository.save(todo);
		return todo;
	}
	public List<Todo> selectAllTodos() {
		return (List<Todo>) todoRepository.findAll();
	}
	public Todo updateCompletedTodo(int id) {
		Todo todo = todoRepository.findById(id).get();
		if(todo.getCompleted().equals("Y")) {
			todo.setCompleted("N");
		}else {
			todo.setCompleted("Y");
		}
		todoRepository.save(todo);
		return todo;
	}
}

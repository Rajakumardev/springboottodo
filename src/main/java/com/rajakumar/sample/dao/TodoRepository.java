package com.rajakumar.sample.dao;

import org.springframework.data.repository.CrudRepository;

import com.rajakumar.sample.model.Todo;

public interface TodoRepository extends CrudRepository<Todo, Integer> {
	
}

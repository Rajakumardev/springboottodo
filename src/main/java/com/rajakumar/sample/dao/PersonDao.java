package com.rajakumar.sample.dao;

import java.util.List;
import java.util.UUID;
import com.rajakumar.sample.model.Person;

public interface PersonDao {
	
	int insertPerson(UUID uuid, Person person);
	default int insertPerson(Person person) {
		UUID uuid = UUID.randomUUID();
		return insertPerson(uuid, person);
	}
	
	List<Person> selectAllPersons();
}

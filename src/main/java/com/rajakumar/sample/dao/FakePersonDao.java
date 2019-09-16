package com.rajakumar.sample.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.rajakumar.sample.model.Person;

@Repository("FakePersonDao")
public class FakePersonDao implements PersonDao {

	private static ArrayList<Person> DB = new ArrayList<>();
	
	@Override
	public int insertPerson(UUID uuid, Person person) {
		DB.add(new Person(uuid,person.getName()));
		return 1;
	}

	@Override
	public List<Person> selectAllPersons() {
		return DB;
	}
}

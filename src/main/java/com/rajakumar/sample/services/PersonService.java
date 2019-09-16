package com.rajakumar.sample.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.rajakumar.sample.dao.PersonDao;
import com.rajakumar.sample.model.Person;

@Service
public class PersonService {
	private PersonDao personDao;
	@Autowired
	public PersonService(@Qualifier("FakePersonDao") PersonDao personDao) {
		super();
		this.personDao = personDao;
	}

	public int addPersion(Person person) {
		personDao.insertPerson(person);
		return 1;
	}
	
	public List<Person> selectAllPersons() {
		personDao.selectAllPersons();
		return personDao.selectAllPersons();
	}
}

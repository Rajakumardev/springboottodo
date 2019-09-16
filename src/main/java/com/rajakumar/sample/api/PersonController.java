package com.rajakumar.sample.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rajakumar.sample.model.Person;
import com.rajakumar.sample.services.PersonService;
@RequestMapping("/api/v1/person")
@RestController
public class PersonController {
	private PersonService personService;
	@Autowired
	public PersonController(PersonService personService) {
		super();
		this.personService = personService;
	}

	@PostMapping
	public Person addPerson(@RequestBody Person person) {
		System.out.println(person.toString());
		personService.addPersion(person);
		return person;
	}
	@GetMapping
	public List<Person> selectAllPersons(){
		return personService.selectAllPersons();
	}
}

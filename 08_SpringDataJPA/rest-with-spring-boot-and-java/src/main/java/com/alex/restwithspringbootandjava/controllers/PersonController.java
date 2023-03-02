package com.alex.restwithspringbootandjava.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alex.restwithspringbootandjava.model.Person;
import com.alex.restwithspringbootandjava.services.PersonServices;

@RestController
@RequestMapping("/persons")
public class PersonController {

	@Autowired
	private PersonServices service;

	@GetMapping()
	public List<Person> findAll() {
		return service.findAll();
	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Person findById(@PathVariable(value = "id") Long id) {
		return service.findById(id);
	}

	@PostMapping()
	public Person create(@RequestBody Person person) {
		return service.create(person);
	}

	@PutMapping()
	public Person update(@RequestBody Person person) {
		return service.update(person);
	}

	@DeleteMapping()
	public void delete(@PathVariable(value = "id") Long id) {
		service.delete(id);
	}
}

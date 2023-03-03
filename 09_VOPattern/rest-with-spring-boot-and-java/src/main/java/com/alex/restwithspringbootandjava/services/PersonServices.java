package com.alex.restwithspringbootandjava.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alex.restwithspringbootandjava.data.vo.v1.PersonVO;
import com.alex.restwithspringbootandjava.exceptions.ResourceNotFoundException;
import com.alex.restwithspringbootandjava.repositories.PersonRepository;

@Service
public class PersonServices {

	private Logger logger = Logger.getLogger(PersonServices.class.getName());

	@Autowired
	PersonRepository repository;

	public List<PersonVO> findAll() {

		logger.info("Finding all people!");

		return repository.findAll();
	}

	public PersonVO findById(Long id) {

		logger.info("Finding one PersonVO!");

		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!	"));
	}

	public PersonVO create(PersonVO person) {

		logger.info("Creating one PersonVO!");
		return repository.save(person);
	}

	public PersonVO update(PersonVO person) {

		logger.info("updating one PersonVO!");
		PersonVO entity = findById(person.getId());
		
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());

		return repository.save(entity);
	}

	public void delete(Long id) {
		logger.info("Deleting one PersonVO!");
		PersonVO PersonVO = findById(id);
		
		repository.delete(PersonVO);
	}

}

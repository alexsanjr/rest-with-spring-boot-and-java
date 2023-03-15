package com.alex.restwithspringbootandjava.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.stereotype.Service;

import com.alex.restwithspringbootandjava.controllers.PersonController;
import com.alex.restwithspringbootandjava.data.vo.v1.PersonVO;
import com.alex.restwithspringbootandjava.exceptions.RequiredObjectIsNullException;
import com.alex.restwithspringbootandjava.exceptions.ResourceNotFoundException;
import com.alex.restwithspringbootandjava.mapper.DozerMapper;
import com.alex.restwithspringbootandjava.model.Person;
import com.alex.restwithspringbootandjava.repositories.PersonRepository;

@Service
public class PersonServices {

	private Logger logger = Logger.getLogger(PersonServices.class.getName());

	@Autowired
	PersonRepository repository;

	public List<PersonVO> findAll() {

		logger.info("Finding all people!");

		List<PersonVO> persons =  DozerMapper.parseListObjects(repository.findAll(), PersonVO.class);
		persons.stream().forEach(p -> p.add(linkTo(methodOn(PersonController.class)
				.findById(p.getKey())).withSelfRel()));
		return persons;
	}

	public PersonVO findById(Long id) {

		logger.info("Finding one PersonVO!");

		Person entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!	"));
		PersonVO vo =  DozerMapper.parseObject(entity, PersonVO.class);
		vo.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());
		return vo;
	}

	public PersonVO create(PersonVO person) {
		if (person == null) throw new RequiredObjectIsNullException();

		logger.info("Creating one PersonVO!");
		Person entity = DozerMapper.parseObject(person, Person.class);
		PersonVO vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);
		vo.add(linkTo(methodOn(PersonController.class).findById(vo.getKey())).withSelfRel());
		return vo;
	}

	public PersonVO update(PersonVO person) {

		if (person == null) throw new RequiredObjectIsNullException();
		logger.info("updating one PersonVO!");
		Person entity = repository.findById(person.getKey())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!	"));

		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());

		PersonVO vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);
		vo.add(linkTo(methodOn(PersonController.class).findById(vo.getKey())).withSelfRel());
		return vo;
	}

	public void delete(Long id) {
		logger.info("Deleting one PersonVO!");
		Person person = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!	"));

		repository.delete(person);
	}

}

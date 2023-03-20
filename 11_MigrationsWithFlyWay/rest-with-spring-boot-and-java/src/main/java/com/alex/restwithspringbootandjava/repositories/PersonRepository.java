package com.alex.restwithspringbootandjava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alex.restwithspringbootandjava.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}

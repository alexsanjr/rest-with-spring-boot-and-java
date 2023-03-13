package com.alex.restwithspringbootandjava.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alex.restwithspringbootandjava.model.Books;
import com.alex.restwithspringbootandjava.services.BooksServices;
import com.alex.restwithspringbootandjava.util.MediaType;

@RestController
@RequestMapping("/api/books/v1")
public class BooksController {
	
	@Autowired
	BooksServices service;
	
	@GetMapping(produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML })
	public ResponseEntity<List<Books>> findAll() {
		
		return ResponseEntity.ok(service.findAll());
	}

}

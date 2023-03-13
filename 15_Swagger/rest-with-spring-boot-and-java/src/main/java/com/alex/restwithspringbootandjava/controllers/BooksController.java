package com.alex.restwithspringbootandjava.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.alex.restwithspringbootandjava.data.vo.v1.BooksVO;
import com.alex.restwithspringbootandjava.services.BooksServices;
import com.alex.restwithspringbootandjava.util.MediaType;

@RestController
@RequestMapping("/api/books/v1")
public class BooksController {
	
	@Autowired
	BooksServices service;
	
	@GetMapping(produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML })
	public ResponseEntity<List<BooksVO>> findAll() {
		return ResponseEntity.ok(service.findAll());
	}
	
	@GetMapping(value= "/{id}",
			produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML })
	public ResponseEntity<BooksVO> findById(@PathVariable Long id) {
		return ResponseEntity.ok(service.findById(id));
	}
	
	@PostMapping(
			consumes = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML}, 
			produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML })
	public ResponseEntity<BooksVO> create(@RequestBody BooksVO vo) {
		vo = service.create(vo);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(vo.getKey()).toUri();
		return ResponseEntity.created(uri).body(vo);
	}
	
	@PutMapping(
			consumes = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML }, 
			produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML })
	public ResponseEntity<BooksVO> update(@RequestBody BooksVO vo) {
		vo = service.update(vo);
		return ResponseEntity.ok(vo);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}

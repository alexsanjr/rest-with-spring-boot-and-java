package com.alex.restwithspringbootandjava.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alex.restwithspringbootandjava.data.vo.v1.BooksVO;
import com.alex.restwithspringbootandjava.mapper.DozerMapper;
import com.alex.restwithspringbootandjava.model.Books;
import com.alex.restwithspringbootandjava.repositories.BooksRepository;

@Service
public class BooksServices {

	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	@Autowired
	BooksRepository repository;

	public List<BooksVO> findAll() {
		
		logger.info("Finding all books!");
		List<Books> books = repository.findAll();
		return DozerMapper.parseListObjects(books, BooksVO.class);
	}
}

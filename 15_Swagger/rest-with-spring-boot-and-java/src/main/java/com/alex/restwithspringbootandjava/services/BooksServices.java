package com.alex.restwithspringbootandjava.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alex.restwithspringbootandjava.data.vo.v1.BooksVO;
import com.alex.restwithspringbootandjava.exceptions.ResourceNotFoundException;
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
		List<BooksVO> vo = DozerMapper.parseListObjects(books, BooksVO.class);
		return vo;
	}

	public BooksVO findById(Long id) {
		logger.info("Finding one BooksVO!");
		Books books = repository.findById(id).orElseThrow(() ->new ResourceNotFoundException("No records found for this ID!	"));
		
		BooksVO vo = DozerMapper.parseObject(books, BooksVO.class);
		return vo;
	}

	public BooksVO create(BooksVO vo) {
		Books book = DozerMapper.parseObject(vo, Books.class);
		book = repository.save(book);
		return DozerMapper.parseObject(book, BooksVO.class);
		
	}

	public BooksVO update(BooksVO vo) {
		Books book = repository.getReferenceById(vo.getKey());
		book = DozerMapper.parseObject(vo, Books.class);
		book = repository.save(book);
		
		return DozerMapper.parseObject(book, BooksVO.class);
	}

	public void delete(Long id) {
		Books book = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!	"));
		repository.delete(book);
	}
}

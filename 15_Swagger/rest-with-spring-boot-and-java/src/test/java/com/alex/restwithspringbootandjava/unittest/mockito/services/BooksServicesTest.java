package com.alex.restwithspringbootandjava.unittest.mockito.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.alex.restwithspringbootandjava.data.vo.v1.BooksVO;
import com.alex.restwithspringbootandjava.exceptions.RequiredObjectIsNullException;
import com.alex.restwithspringbootandjava.model.Books;
import com.alex.restwithspringbootandjava.repositories.BooksRepository;
import com.alex.restwithspringbootandjava.services.BooksServices;
import com.alex.restwithspringbootandjava.unittests.mapper.mocks.MockBooks;

@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
class BooksServicesTest {

	MockBooks input;

	@InjectMocks
	private BooksServices service;

	@Mock
	BooksRepository repository;

	@BeforeEach
	void setUpMocks() throws Exception {
		input = new MockBooks();
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testFindAll() {
		List<Books> list = input.mockEntityList();

		when(repository.findAll()).thenReturn(list);

		List<BooksVO> books = service.findAll();
		assertNotNull(books);
		assertEquals(14, books.size());

		BooksVO bookOne = books.get(1);

		assertNotNull(bookOne);
		assertNotNull(bookOne.getKey());
		assertNotNull(bookOne.getLinks());

		assertTrue(bookOne.toString().contains("links: [</api/books/v1/1>;rel=\"self\"]"));
		assertEquals("Author test1", bookOne.getAuthor());
		assertEquals(1.0, bookOne.getPrice());
		assertNotNull(bookOne.getLaunchTime());
		assertEquals("Title test1", bookOne.getTitle());

		BooksVO bookFour = books.get(4);

		assertNotNull(bookFour);
		assertNotNull(bookFour.getKey());
		assertNotNull(bookFour.getLinks());

		assertTrue(bookFour.toString().contains("links: [</api/books/v1/4>;rel=\"self\"]"));
		assertEquals("Author test4", bookFour.getAuthor());
		assertEquals(4.0, bookFour.getPrice());
		assertNotNull(bookFour.getLaunchTime());
		assertEquals("Title test4", bookFour.getTitle());

		BooksVO bookSeven = books.get(7);

		assertNotNull(bookSeven);
		assertNotNull(bookSeven.getKey());
		assertNotNull(bookSeven.getLinks());

		assertTrue(bookSeven.toString().contains("links: [</api/books/v1/7>;rel=\"self\"]"));
		assertEquals("Author test7", bookSeven.getAuthor());
		assertEquals(7.0, bookSeven.getPrice());
		assertNotNull(bookSeven.getLaunchTime());
		assertEquals("Title test7", bookSeven.getTitle());
	}

	@Test
	void testFindById() {
		Books entity = input.mockEntity(1);

		when(repository.findById(1L)).thenReturn(Optional.of(entity));

		BooksVO result = service.findById(1L);

		assertNotNull(result);
		assertNotNull(result.getKey());
		assertNotNull(result.getLinks());
		assertTrue(result.toString().contains("links: [</api/books/v1/1>;rel=\"self\"]"));
		assertEquals("Author test1", result.getAuthor());
		assertEquals(1.0, result.getPrice());
		assertNotNull(result.getLaunchTime());
		assertEquals("Title test1", result.getTitle());
	}

	@Test
	void testCreate() {
		Books entity = input.mockEntity(1);
		Books persisted = entity;

		BooksVO vo = input.mockVO(1);

		when(repository.save(entity)).thenReturn(persisted);

		BooksVO result = service.create(vo);

		assertNotNull(result);
		assertNotNull(result.getKey());
		assertNotNull(result.getLinks());
		assertTrue(result.toString().contains("links: [</api/books/v1/1>;rel=\"self\"]"));
		
		assertEquals("Author test1", result.getAuthor());
		assertEquals(1.0, result.getPrice());
		assertNotNull(result.getLaunchTime());
		assertEquals("Title test1", result.getTitle());
	}
	
	@Test
	void testCreateWithNullBooks() {
		Exception exception = assertThrows(RequiredObjectIsNullException.class, () -> service.create(null));

		String expectedMessage = "It is not allowed to persist a null object!";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	void testUpdate() {
		Books entity = input.mockEntity(1);
		entity.setId(1L);

		Books persisted = entity;
		persisted.setId(1L);

		BooksVO vo = input.mockVO(1);
		vo.setKey(1L);

		when(repository.findById(1L)).thenReturn(Optional.of(entity));
		when(repository.save(entity)).thenReturn(persisted);

		BooksVO result = service.update(vo);

		assertNotNull(result);
		assertNotNull(result.getKey());
		assertNotNull(result.getLinks());

		//assertTrue(result.toString().contains("links: [</api/person/v1/1>;rel=\"self\"]"));
		assertEquals("Author test1", result.getAuthor());
		assertEquals(1.0, result.getPrice());
		assertNotNull(result.getLaunchTime());
		assertEquals("Title test1", result.getTitle());
	}

	@Test
	void testUpdateWithNullBooks() {
		Exception exception = assertThrows(RequiredObjectIsNullException.class, () -> service.update(null));

		String expectedMessage = "It is not allowed to persist a null object!";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	void testDelete() {
		Books entity = input.mockEntity(1);
		entity.setId(1L);

		when(repository.findById(1L)).thenReturn(Optional.of(entity));

		service.delete(entity.getId());
	}

}

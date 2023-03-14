package com.alex.restwithspringbootandjava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alex.restwithspringbootandjava.model.Books;

public interface BooksRepository extends JpaRepository<Books, Long> {

}

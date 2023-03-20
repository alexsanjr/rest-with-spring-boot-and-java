package com.alex.restwithspringbootandjava.unittests.mapper.mocks;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.alex.restwithspringbootandjava.data.vo.v1.BooksVO;
import com.alex.restwithspringbootandjava.model.Books;

public class MockBooks {


    public Books mockEntity() {
        return mockEntity(0);
    }
    
    public BooksVO mockVO() {
        return mockVO(0);
    }
    
    public List<Books> mockEntityList() {
        List<Books> books = new ArrayList<Books>();
        for (int i = 0; i < 14; i++) {
        	books.add(mockEntity(i));
        }
        return books;
    }

    public List<BooksVO> mockVOList() {
        List<BooksVO> books = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            books.add(mockVO(i));
        }
        return books;
    }
    
    public Books mockEntity(Integer number) {
    	Books books = new Books();
    	books.setId(number.longValue());
    	books.setAuthor("Author test" + number);
    	books.setPrice(number * 1.0);
    	books.setLaunchTime(LocalDateTime.now());
    	books.setTitle("Title test" + number);
        
        return books;
    }

    public BooksVO mockVO(Integer number) {
    	BooksVO books = new BooksVO();
    	books.setKey(number.longValue());
    	books.setAuthor("Author test" + number);
    	books.setPrice(number * 1.0);
    	books.setLaunchTime(LocalDateTime.now());
    	books.setTitle("Title test" + number);
        return books;
    }

}

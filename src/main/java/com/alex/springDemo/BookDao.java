package com.alex.springDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDao {

    @Autowired
    BookRepository bookRepository;

    // Do' il nome "books" e la chiave costante "'ALL_BOOKS'" alla cache
    @Cacheable(value="books", key="'ALL_BOOKS'")
    public List<Book> findAllAndSaveInCache() {

        System.out.println("First Time, No Cache!");
        return bookRepository.findAll();
    }
}

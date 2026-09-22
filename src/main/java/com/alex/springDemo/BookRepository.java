package com.alex.springDemo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// Creo un repository per la tabella Book che ha indice (ID) di tipo Integer
public interface BookRepository extends JpaRepository<Book, Integer> {

    // Questo e' tutto quello che serve per le operazioni CRUD
    // (SpringBoot si occupa di scrivere SQL e di gestire result set)
    List<Book> findByAuthor(String author);

    List<Book> findByTitleContaining(String keyword);

    List<Book> findByPriceBetween(double minPrice, double maxPrice);
}

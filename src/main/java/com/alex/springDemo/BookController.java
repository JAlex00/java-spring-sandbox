package com.alex.springDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Per gestire richieste di tipo REST
@Controller
public class BookController {

    @Autowired
    BookRepository bookRepository;

    /** Spring REST
     * Creo l'API /books che accetta una richiesta POST
     * Passo un BODY che viene mappato con l-oggetto Book
     * */
    @PostMapping("/books")
    public Book createBook(@RequestBody Book book) {

        // chiamo il metodo SAVE per creare un nuovo record nella tabella bookstore
        Book savedBook = bookRepository.save(book);
        return savedBook;
    }

    // OSS. Non funziona senza costruttore di Default
    @GetMapping("/books")
    public List<Book> retrieveAllBooks() {
        return bookRepository.findAll();
    }

    /**
     * Per aggiornare un record, devo conoscere l'ID
     * passo l'ID come PATH VARIABLE (variabile del percorso /books/{id})
     * */
    @PutMapping("/books/{id}")
    public Book updateBook(@PathVariable int id, @RequestBody Book book) {

        book.setId(id);
        return bookRepository.save(book);
    }

    // ResponseEntity ritorna uno status code (http status)
    @DeleteMapping("/books/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable int id, @RequestBody Book book) {
        book.setId(id);
        bookRepository.delete(book);
        return ResponseEntity.ok().build();
    }

    /** POST vs PUT
     * POST e' Idempotente: piu' richieste generano risorse duplicate
     * PUT NON e' Idempotente: piu' richieste producono lo stesso identico risultato
     * */
}

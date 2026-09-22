package com.alex.springDemo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/** ORM (Object Relational Mapping)
 * Una Entity e' un POJO (Plain Old Java Object) mappato su una tabella di DB
 * JPA (Java Persistence Application) e' una specifica di Java
 * che mette a disposizione funzioni ORM
 * Hibernate implementa queste funzioni
 * */
@Entity
public class Book {

    // N.B. Se la tabella Book non esiste, verra' generata

    // Queste annotation servono per specificare che il campo ID deve essere una primary key auto-generata
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    // aggiungendo nuovi campi, la tabella verra' aggiornata
    private String author;
    private double price;

    public Book() {
    }

    public Book(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }
}

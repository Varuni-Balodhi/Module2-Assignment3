package com.example.app.service;
import com.example.app.entity.Book;
import java.util.List;

public interface BookService {
    void addBook(Book book);
    Book getBook(int id);
    List<Book> getAllBooks();
    void updateBook(Book book);
    void deleteBook(int id);
}

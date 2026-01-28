package com.example.app.dao;
import com.example.app.entity.Book;
import java.util.List;

public interface BookDao {
    void save(Book book);
    Book findById(int id);
    List<Book> findAll();
    void update(Book book);
    void delete(int id);
}
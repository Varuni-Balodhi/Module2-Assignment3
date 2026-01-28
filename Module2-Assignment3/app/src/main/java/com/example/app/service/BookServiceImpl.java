package com.example.app.service;
import com.example.app.dao.BookDao;
import com.example.app.dao.BookDaoImpl;
import com.example.app.entity.Book;

import java.util.List;

public class BookServiceImpl implements BookService {

    private BookDao bookDao = new BookDaoImpl();

    @Override
    public void addBook(Book book) {
        if (book.getPrice() <= 0) {
            throw new IllegalArgumentException("Price must be positive");
        }
        bookDao.save(book);
    }

    @Override
    public Book getBook(int id) {
        return bookDao.findById(id);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookDao.findAll();
    }

    @Override
    public void updateBook(Book book) {
        bookDao.update(book);
    }

    @Override
    public void deleteBook(int id) {
        bookDao.delete(id);
    }
}

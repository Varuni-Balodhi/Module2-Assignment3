package com.example.app.dao;
import com.example.app.entity.Book;
import com.example.app.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class BookDaoImpl implements BookDao {

    @Override
    public void save(Book book) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        em.persist(book);
        tx.commit();

        em.close();
    }

    @Override
    public Book findById(int id) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        Book book = em.find(Book.class, id);
        em.close();
        return book;
    }

    @Override
    public List<Book> findAll() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        List<Book> list = em
                .createQuery("FROM Book", Book.class)
                .getResultList();
        em.close();
        return list;
    }

    @Override
    public void update(Book book) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        em.merge(book);
        tx.commit();

        em.close();
    }

    @Override
    public void delete(int id) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();

        Book book = em.find(Book.class, id);
        if (book != null) {
            tx.begin();
            em.remove(book);
            tx.commit();
        }

        em.close();
    }
}
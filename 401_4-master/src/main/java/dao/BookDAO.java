package dao;

import core.IDB;
import interseptors.LoggingInterceptor;
import entity.Book;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Stateless
@Interceptors(LoggingInterceptor.class)
public class BookDAO {

    private EntityManager em = Persistence.createEntityManagerFactory("DEVMODE").createEntityManager();

    public Book create(Book Book) {

        em.getTransaction().begin();
        Book book=em.merge(Book);
        em.getTransaction().commit();
        return book;
    }

    public Book read(int id) {

        return em.find(Book.class,id);
    }

    public void delete(int id) {
        em.getTransaction().begin();
        em.remove(read(id));
        em.getTransaction().commit();
    }

    public void update(Book Book) {
        em.getTransaction().begin();
        em.merge(Book);
        em.getTransaction().commit();
    }

    public List<Book> findByBranch(String branch) {

        TypedQuery<Book> query =
                em.createNamedQuery("Book.findByBranch", Book.class);

        query.setParameter("branch", branch);

        return query.getResultList();
    }

    public List<Book> findByName(String name) {

        TypedQuery<Book> query =
                em.createNamedQuery("Book.findByName", Book.class);

        query.setParameter("name", name);

        return query.getResultList();
    }
    public List<Book> findAll() {

        TypedQuery<Book> query =
                em.createNamedQuery("Book.findAll", Book.class);

        return query.getResultList();
    }
}

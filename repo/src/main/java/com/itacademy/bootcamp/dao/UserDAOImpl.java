package com.itacademy.bootcamp.dao;

import com.itacademy.bootcamp.dao.UserDAO;
import com.itacademy.bootcamp.model.User;
import com.itacademy.bootcamp.exception.DAOException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.hibernate.HibernateException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManagerFactory;

    @Override
    public Page<User> getAllUsers(Pageable pageable) throws DAOException {
        try {
            Query query = entityManagerFactory.createQuery("Select a from User a order by email");
            int pageNumber = pageable.getPageNumber();
            int pageSize = pageable.getPageSize();
            query.setFirstResult((pageNumber) * pageSize);
            query.setMaxResults(pageSize);
            List users = query.getResultList();
            Query queryCount = entityManagerFactory.createQuery("Select count(id) From User a");
            long count = (long) queryCount.getSingleResult();
            return new PageImpl<User>(users, pageable, count);
        } catch (
                Exception e) {
            throw new DAOException(e);
        }
    }

    @Override
    public Long create(User entity) throws DAOException {
        try {
            entityManagerFactory.persist(entity);
            return entity.getId();
        } catch (
                Exception e) {
            throw new DAOException(e);
        }
    }

    @Override
    public User get(Long userId) throws DAOException {
        try {
           return entityManagerFactory.find(User.class, userId);
        } catch (
                Exception e) {
            throw new DAOException(e);
        }
    }
}


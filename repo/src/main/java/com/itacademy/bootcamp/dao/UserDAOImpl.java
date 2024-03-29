package com.itacademy.bootcamp.dao;

import com.itacademy.bootcamp.model.User;
import com.itacademy.bootcamp.exception.DAOException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    private static final Logger logger = LogManager.getLogger(UserDAOImpl.class);

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
        } catch (HibernateException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public Long create(User entity) throws DAOException {
        try {
            logger.info("Persist user");
            entityManagerFactory.persist(entity);
            return entity.getId();
        } catch (HibernateException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public User get(Long userId) throws DAOException {
        try {
            return entityManagerFactory.find(User.class, userId);
        } catch (HibernateException e) {
            throw new DAOException(e);
        }
    }
}


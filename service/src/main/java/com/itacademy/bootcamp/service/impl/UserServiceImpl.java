package com.itacademy.bootcamp.service.impl;

import com.itacademy.bootcamp.dao.UserDAO;
import com.itacademy.bootcamp.exception.DAOException;
import com.itacademy.bootcamp.exception.ServiceException;
import com.itacademy.bootcamp.model.User;
import com.itacademy.bootcamp.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LogManager.getLogger(UserServiceImpl.class);
    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public  Page<User> getUsers(Pageable pageable) throws ServiceException {
        try {
            logger.info("Get all users.");
            return userDAO.getAllUsers(pageable);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    @Transactional
    public Long create(User entity) throws ServiceException {
        try {
            logger.info("Сreate user has started.");
            return userDAO.create(entity);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
    @Override
    public User get(Long userId) throws ServiceException {
        try {
            logger.info("Get user by Id");
            return userDAO.get(userId);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}

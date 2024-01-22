package com.itacademy.bootcamp.dao;

import com.itacademy.bootcamp.model.User;
import com.itacademy.bootcamp.exception.DAOException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserDAO extends DAOManager<User> {
    /**
     * Get list of users
     *
     * @return List<User>
     */
    Page<User> getAllUsers(Pageable pageable) throws DAOException;

    Long create(User user) throws DAOException;

    User get(Long userId) throws DAOException;
}

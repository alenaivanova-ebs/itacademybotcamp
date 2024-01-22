package com.itacademy.bootcamp;

import com.itacademy.bootcamp.model.User;
import com.itacademy.bootcamp.exception.ServiceException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
      Page<User> getUsers(Pageable pageable) throws ServiceException;

    Long create(User entity) throws ServiceException;

    User get(Long userId) throws ServiceException;
}

package com.itacademy.bootcamp.dao;


import com.itacademy.bootcamp.exception.DAOException;

public interface DAOManager<T> {
    Long create(T entity) throws DAOException;

}


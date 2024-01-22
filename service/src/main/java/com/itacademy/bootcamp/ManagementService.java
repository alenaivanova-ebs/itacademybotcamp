package com.itacademy.bootcamp;


import com.itacademy.bootcamp.exception.ServiceException;

public interface ManagementService<T> {
    /**
     * Create entity in database
     *
     * @param entity entity that should be created
     * @return id of entity that is created in database
     * @throws ServiceException if trouble either in DAO or Service layer
     */
    Long create(T entity) throws ServiceException;

    /**
     * Read entity from database
     *
     * @param id of entity that should be read
     * @return Entity from database by id;
     * @throws ServiceException if trouble either in DAO or Service layer
     */
    T get(Long id) throws ServiceException;

    /**
     * Update entity in database
     *
     * @param entity Entity that should be updated
     * @throws ServiceException if trouble with connection in DAO layer
     */
    void update(T entity) throws ServiceException;

    /**
     * Delete entity from database
     *
     * @param id of entity that should be deleted
     * @throws ServiceException if trouble with connection in DAO layer
     */
    boolean delete(Long id) throws ServiceException;
}


//package com.itacademy.bootcamp.dao;
//import com.itacademy.bootcamp.exception.DAOException;
//import com.itacademy.bootcamp.model.Role;
//import com.itacademy.bootcamp.model.User;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.jdbc.Sql;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.context.support.AnnotationConfigContextLoader;
//import org.springframework.transaction.annotation.Transactional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//
//@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = {InitTestDataBaseConfig.class, UserDAOImpl.class},
//        loader = AnnotationConfigContextLoader.class)
//@Transactional
//@Sql({"/init.sql", "/populate.sql"})
//public class UserDAOImplIntTest {
//
//    @Autowired
//    private UserDAO userDAO;
//
//    @Test
//    public void testRead() throws DAOException {
//        Long id = userDAO.create(new User(1L,"test","test","test","test", Role.ADMIN));
//        assertEquals(id, 1L);
//
//    }
//
//
//}

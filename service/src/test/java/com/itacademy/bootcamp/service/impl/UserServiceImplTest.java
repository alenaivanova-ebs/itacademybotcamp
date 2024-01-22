//package com.itacademy.bootcamp.service.impl;
//
//import com.itacademy.bootcamp.dao.UserDAO;
//import com.itacademy.bootcamp.exception.DAOException;
//import com.itacademy.bootcamp.exception.ServiceException;
//import com.itacademy.bootcamp.model.Role;
//import com.itacademy.bootcamp.model.User;
//
//import com.itacademy.bootcamp.service.impl.impl.UserServiceImpl;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//@ExtendWith(MockitoExtension.class)
//public class UserServiceImplTest {
//
//    @Mock
//    private UserDAO userDAO;
//    private AutoCloseable closeable;
//    @InjectMocks
//    private UserServiceImpl userService;
//
//    @BeforeEach
//    void initService() {
//        closeable = MockitoAnnotations.openMocks(this);
//    }
//
//    @AfterEach
//    void closeService() throws Exception {
//        closeable.close();
//    }
//    @Test
//    public void testGet() throws DAOException, ServiceException {
//        User user = getUser();
//        Mockito.when(userDAO.get(1L)).thenReturn(user);
//        User userActual = userService.get(1L);
//        assertEquals(user, userActual);
//    }
//
//    public User getUser() {
//        User user = new User();
//        user.setId(1L);
//        user.setUsername("name");
//        user.setRole(Role.ADMIN);
//        return user;
//    }
//}
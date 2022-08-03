package com.example.webtask.service;

import com.example.webtask.model.entity.User;
import com.example.webtask.repository.UserRepository;
import com.example.webtask.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

public class UserServiceImplTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userServiceImpl;

    private User user;

    @BeforeEach
    void initService() {
        MockitoAnnotations.openMocks(this);
//        userService = new UserService(iUserReponsitory);
        user = new User();

    }

    @Test
    void testCheckLogin(){
        when(userRepository.findByUsernameAndPassword("dinhnam","matkhaula123")).thenReturn(user);
        assertTrue(userServiceImpl.checkLogin("dinhnam", "matkhaula123"));
    }

    @Test
    void testCheckExistUsername(){
//        when(iUserReponsitory.findByUsername("dinhnam")).thenReturn(user);
        assertTrue(userServiceImpl.checkExistUsername("dinhnam"));
    }

}

package com.example.webtask.service;

import com.example.webtask.model.User;
import com.example.webtask.repository.IUserReponsitory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

public class UserServiceTest {
    @Mock
    private IUserReponsitory iUserReponsitory;

    @InjectMocks
    private UserService userService;

    private User user;

    @BeforeEach
    void initService() {
        MockitoAnnotations.openMocks(this);
//        userService = new UserService(iUserReponsitory);
        user = new User();

    }

    @Test
    void testCheckLogin(){
        when(iUserReponsitory.findByUsernameAndPassword("dinhnam","matkhaula123")).thenReturn(user);
        assertTrue(userService.checkLogin("dinhnam", "matkhaula123"));
    }

    @Test
    void testCheckExistUsername(){
//        when(iUserReponsitory.findByUsername("dinhnam")).thenReturn(user);
        assertTrue(userService.checkExistUsername("dinhnam"));
    }

}

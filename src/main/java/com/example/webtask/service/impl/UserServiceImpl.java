package com.example.webtask.service.impl;

import com.example.webtask.mapper.UserMapper;
import com.example.webtask.model.User;
import com.example.webtask.repository.UserRepository;
import com.example.webtask.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    @Override
    public boolean checkLogin(String username, String password) {
        if (userMapper.findByUsernameAndPassword(username, password) != null) {
            return true;
        }
        return false;
    }

    @Override
    public boolean checkExistUsername(String username) {
        if (userMapper.findByUsername(username) != null) {
            return true;
        }
        return false;
    }

    @Override
    public void save(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userMapper.insertUser(user);
    }

}

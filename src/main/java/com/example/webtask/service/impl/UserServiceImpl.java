package com.example.webtask.service.impl;

import com.example.webtask.model.entity.User;
import com.example.webtask.repository.UserRepository;
import com.example.webtask.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public boolean checkLogin(String username, String password) {
        if(userRepository.findByUsernameAndPassword(username, password) != null){
            return true;
        }
        return false;
    }

    @Override
    public boolean checkExistUsername(String username) {
        if(userRepository.findByUsername(username) != null){
            return true;
        }
        return false;
    }

    @Override
    public void save(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

}

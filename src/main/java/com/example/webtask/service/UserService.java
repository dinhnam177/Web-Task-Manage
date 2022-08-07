package com.example.webtask.service;

import com.example.webtask.model.User;

public interface UserService {
    boolean checkLogin(String username, String password);

    boolean checkExistUsername(String username);

    void save(User user);
}

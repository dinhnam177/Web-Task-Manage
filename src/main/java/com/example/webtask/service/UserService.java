package com.example.webtask.service;

import com.example.webtask.model.CustomUserDetails;
import com.example.webtask.model.User;
import com.example.webtask.repository.IUserReponsitory;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final IUserReponsitory iUserReponsitory;

    @Override
    public boolean checkLogin(String username, String password) {
        if(iUserReponsitory.findByUsernameAndPassword(username, password) != null){
            return true;
        }
        return false;
    }

    @Override
    public boolean checkExistUsername(String username) {
        if(iUserReponsitory.findByUsername(username) != null){
            return true;
        }
        return false;
    }

    @Override
    public void save(User user) {
        iUserReponsitory.save(user);
    }

}

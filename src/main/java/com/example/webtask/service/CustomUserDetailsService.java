package com.example.webtask.service;

import com.example.webtask.model.CustomUserDetails;
import com.example.webtask.model.User;
import com.example.webtask.repository.IUserReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    IUserReponsitory iUserReponsitory;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = iUserReponsitory.findByUsername(username);

        if(user == null){
            throw  new UsernameNotFoundException("Not found: " + username);
        }

        return new CustomUserDetails(user);
    }
}

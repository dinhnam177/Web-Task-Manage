package com.example.webtask.mapper;

import com.example.webtask.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface UserMapper {
    User findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    User findByUsername(@Param("username") String username);

    void insertUser(@Param("user") User user);
}

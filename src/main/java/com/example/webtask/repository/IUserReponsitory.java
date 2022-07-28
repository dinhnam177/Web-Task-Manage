package com.example.webtask.repository;

import com.example.webtask.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserReponsitory extends JpaRepository<User, String> {
    User findByUsernameAndPassword(String username,String password);
    User findByUsername(String username);

//    Optional<User> findByUsername(String username);
}

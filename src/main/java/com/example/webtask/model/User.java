package com.example.webtask.model;

import com.example.webtask.model.Task;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "email")
    private String email;

    @NotBlank(message = "UserName is can't not Blank")
    @Column(name = "username")
    private String username;

    @NotBlank(message = "Password is can't not Blank")
    @Column(name = "password")
    private String password;

    @Fetch(FetchMode.SUBSELECT)
    @OneToMany(mappedBy="userTask", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Task> tasks;
}

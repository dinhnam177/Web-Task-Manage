package com.example.webtask.model;

import com.example.webtask.model.Task;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
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

    @Pattern(regexp = "^[A-Za-z0-9]*$", message = "Tài khoản không được có ký tự đặc biệt !!!")
    @NotBlank(message = "UserName is can't not Blank")
    @Column(name = "username")
    private String username;

    //Tối thiểu tám ký tự, ít nhất một chữ hoa, một chữ thường và một số
//    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[0-9])[a-zA-Z]{8,}$", message = "Mật khẩu phải có A-Z, a-z, lớn hơn 8 ký tự !!!")
    @NotBlank(message = "Password is can't not Blank")
    @Column(name = "password")
    private String password;

    @Fetch(FetchMode.SUBSELECT)
    @OneToMany(mappedBy = "userTask", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Task> tasks;
}

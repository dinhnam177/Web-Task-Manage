package com.example.webtask.controller;

import com.example.webtask.model.User;
import com.example.webtask.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    @Autowired
    private IUserService iUserService;
//    @ResponseBody
    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("user", new User());
        return "login";
    }

//    @ResponseBody
    @GetMapping("/login")
    public String showLogin(Model model){
        model.addAttribute("user", new User());
        return "login";
    }

    @GetMapping("/login_fail")
    public String showLoginFail(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("error", "Login fail !!!");
        return "login";
    }


//    @ResponseBody
    @GetMapping("/signup")
    public String signUp(Model model){
        model.addAttribute("user",new User());
        return "signup";
    }
    @PostMapping("/signup")
    public String checkSignUp(@ModelAttribute User user){
        if(!iUserService.checkExistUsername(user.getUsername())){
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            iUserService.save(user);
            return "login";
        }
        return "signup";
    }

}

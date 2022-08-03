package com.example.webtask.controller;

import com.example.webtask.model.entity.User;
import com.example.webtask.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public String processForm(@Valid User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "login";
        }
        model.addAttribute("user", user);
        return "index";
    }

    @GetMapping("/login_fail")
    public String showLoginFail(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("error", "Login fail !!!");
        return "login";
    }

    @GetMapping("/signup")
    public String signUp(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }

    @PostMapping("/signup")
    public String checkSignUp(@ModelAttribute User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "signup";
        } else {
            if (!userService.checkExistUsername(user.getUsername())) {
                userService.save(user);
                return "login";
            }
        }
        return "login";
    }

    //    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    private final JwtUtil jwtTokenUtil;
    //    @PostMapping("/login")
//    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception{
//        try{
//            authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
//            );
//        }catch (BadCredentialsException e) {
//            throw new Exception("Incorrect username or password", e);
//        }
////        }final UserDetails userDetails = customUserDetailsService.loadUserByUsername(authRequest.getUsername());
////        final  String jwt = jwtTokenUtil.generateToken(userDetails);
////        return ResponseEntity.ok(new AuthenticationResponse(jwt));
//        return jwtTokenUtil.generateToken(authRequest.getUsername());
//    }
}

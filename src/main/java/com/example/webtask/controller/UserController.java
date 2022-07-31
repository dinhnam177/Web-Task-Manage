package com.example.webtask.controller;

import com.example.webtask.model.User;
import com.example.webtask.service.IUserService;
import com.example.webtask.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final IUserService iUserService;
    @Autowired
    private AuthenticationManager authenticationManager;

    private final JwtUtil jwtTokenUtil;
//    @ResponseBody
    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("user", new User());
        return "login";
    }

////    @ResponseBody
    @GetMapping("/login")
    public String showLogin(Model model){
        model.addAttribute("user", new User());
        return "login";
    }

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

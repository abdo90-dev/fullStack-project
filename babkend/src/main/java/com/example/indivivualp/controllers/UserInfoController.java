package com.example.indivivualp.controllers;
import com.example.indivivualp.model.UserInfo;
import com.example.indivivualp.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/signup")
public class UserInfoController {
    @Autowired
    private UserServices userServices;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @PostMapping("/register")

    @CrossOrigin(origins = "http://localhost:4200")
    public void getUserInfo(@RequestBody UserInfo userInfo){

        String pwd = userInfo.getPassword();
        String encryptpwd = passwordEncoder.encode(pwd);
        userInfo.setPassword(encryptpwd);
        userServices.save(userInfo);

    }
    @GetMapping("/users")
    public List<UserInfo> getAllUsersByRule(@RequestParam("role") String userRole){

        return userServices.getAllUserByRole(userRole);
    }

}

package com.example.indivivualp.controllers;
import com.example.indivivualp.model.Card;
import com.example.indivivualp.model.UserInfo;
import com.example.indivivualp.services.CardService;
import com.example.indivivualp.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/home")

@CrossOrigin(origins = "http://localhost:4200")
public class HomeController{
    UserInfo user;
    @Autowired
    private CardService homePageService;
    @Autowired
    private UserServices userServices;
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @GetMapping("/news")
    @CrossOrigin(origins = {"http://localhost:4202","http://localhost:4201"})
    public List<Card> getNews() {

        return homePageService.getAll("news");
    }
    @GetMapping("/login")
    public UserInfo login(@RequestParam("email") String email){
        user = userServices.getUserByEmail(email);

        return user;
    }
    @GetMapping("/user")
    public UserInfo getUser(){

        return user;
    }
    @GetMapping("/achievement")
    @CrossOrigin(origins = {"http://localhost:4202","http://localhost:4201"})
    public List<Card> getAchievements(){


        return homePageService.getAll("achievement");
    }
    @PostMapping("/save")
    @CrossOrigin(origins = "http://localhost:4201")
    public void saveCard(@RequestParam("image_url")MultipartFile file,@RequestParam("text") String text,@RequestParam("section") String section,@RequestParam("serviceName") String title) throws IOException {
        Card card = new Card();
        card.setTitle(title);
        card.setImageUrl(file.getBytes());
        card.setText(text);
        card.setSection(section);
        homePageService.saveCard(card);

    }
}

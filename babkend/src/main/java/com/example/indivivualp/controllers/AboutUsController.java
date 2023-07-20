package com.example.indivivualp.controllers;

import com.example.indivivualp.model.Card;
import com.example.indivivualp.model.UserInfo;
import com.example.indivivualp.services.CardService;
import com.example.indivivualp.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/aboutUs")
@CrossOrigin(origins = "http://localhost:4202")
public class AboutUsController {

    @Autowired
    UserServices teamMembers;
    @Autowired
    CardService definition;
Card card;

    @GetMapping("/members")
    @CrossOrigin(origins = "http://localhost:4202")
    public List<UserInfo> getMembers(@RequestParam("role") String userRole){
        return teamMembers.getAllUserByRole(userRole);
    }
    @GetMapping("/definition")
    @CrossOrigin(origins = "http://localhost:4202")
    public Card getDefinition(){
    return definition.getAll("definition").get(0);
    }


}

package com.example.indivivualp.controllers;

import com.example.indivivualp.model.Card;
import com.example.indivivualp.model.ServiceRequest;
import com.example.indivivualp.model.UserInfo;
import com.example.indivivualp.services.CardService;
import com.example.indivivualp.services.Sservice;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/service")
@CrossOrigin(origins = "http://localhost:4202")
public class Services {

    @Autowired
    private CardService cardService;
    @Autowired
    private Sservice service;

    @GetMapping("/services")
    @CrossOrigin(origins = "http://localhost:4202/services")
    public List<Card> getServices(){


        return cardService.getAll("service");
    }
    @PostMapping("/serviceRequest")

    @CrossOrigin(origins = "http://localhost:4202/services")
    public void saveRequest(@RequestParam("file") MultipartFile file,@RequestParam("name") String name,@RequestParam("email") String email,@RequestParam("phone_number") String phone_number,@RequestParam("serviceName") String serviceName,@RequestParam("requirement") String requirement){
        try {

            ServiceRequest serviceRequest = new ServiceRequest(file.getBytes(),email,name,phone_number,serviceName,requirement,file.getOriginalFilename());
            service.save(serviceRequest);
        }catch (IOException e){}
    }
    @GetMapping("/getServicesRequist")

    @CrossOrigin(origins = "http://localhost:4202")
    public List<ServiceRequest> getUserInfo(@RequestParam("email") String email,@RequestParam("action") String action){

        List<ServiceRequest> serviceRequest = service.getServiceByEmail(email,action);

        return  serviceRequest;

    }


}

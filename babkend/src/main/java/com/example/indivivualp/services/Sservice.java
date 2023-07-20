package com.example.indivivualp.services;
import com.example.indivivualp.model.ServiceRequest;
import org.springframework.stereotype.Service;
import com.example.indivivualp.repositorys.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class Sservice {
    @Autowired
    ServiceRepository repository;
    public ServiceRequest save(ServiceRequest userInfo){
        return repository.save(userInfo);

    }
    public List<ServiceRequest> getServiceByEmail( String email,String action){
        List<ServiceRequest> serviceRequest = repository.findAllByEmailAndAction(email,action);
        return serviceRequest;
    }
}

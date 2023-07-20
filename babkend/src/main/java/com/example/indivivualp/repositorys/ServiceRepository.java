package com.example.indivivualp.repositorys;
import com.example.indivivualp.model.ServiceRequest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceRepository extends CrudRepository<ServiceRequest,String>{
    @Override
    ServiceRequest save(ServiceRequest entity);

    List<ServiceRequest> findAllByEmailAndAction(String email,String action);
}

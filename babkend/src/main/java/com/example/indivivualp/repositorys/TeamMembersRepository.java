package com.example.indivivualp.repositorys;

import com.example.indivivualp.model.UserInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamMembersRepository extends CrudRepository<UserInfo,String> {

}

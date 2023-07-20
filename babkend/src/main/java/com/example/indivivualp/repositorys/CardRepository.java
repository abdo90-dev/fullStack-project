package com.example.indivivualp.repositorys;

import com.example.indivivualp.model.Card;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends CrudRepository<Card,String> {
    List<Card> findAllBySection(String sectionName);

    @Override
     Card save(Card entity);
}

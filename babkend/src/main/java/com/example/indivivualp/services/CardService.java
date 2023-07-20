package com.example.indivivualp.services;

import com.example.indivivualp.model.Card;
import com.example.indivivualp.repositorys.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

@Service
public class CardService {
    @Autowired
    CardRepository repository;
    public List<Card> getAll(String sectionName){
        List<Card> cards = repository.findAllBySection(sectionName);
        for (int i =0;i<cards.size();i++ ) {
            System.out.println(cards.get(i).getImageUrl());
            cards.get(i).setImageUrl(decompressBytes(cards.get(i).getImageUrl()));
        }
        return cards;
    }
    public static byte[] decompressBytes(byte[] data) {
        Inflater inflater = new Inflater();
        inflater.setInput(data);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        try {
            while (!inflater.finished()) {
                int count = inflater.inflate(buffer);
                outputStream.write(buffer, 0, count);
            }
            outputStream.close();
        } catch (IOException ioe) {
        } catch (DataFormatException e) {
        }
        return outputStream.toByteArray();
    }
    public Card saveCard(Card card){

        return repository.save(card);

    }
}

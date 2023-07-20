package com.example.indivivualp.model;

import lombok.Data;

import javax.persistence.*;


@Entity
@Table(name = "chats")
@Data
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    private UserInfo sender;

    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private UserInfo receiver;
    }




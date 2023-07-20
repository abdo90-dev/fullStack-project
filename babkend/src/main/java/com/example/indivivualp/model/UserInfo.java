package com.example.indivivualp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class UserInfo {

    @Column(name = "first_name")
    String first ;
    @Column(name = "last_name")
    String last;
    @Id
    @Column
    String email ;
    @Column
    String password ;
    @Column
    String phone_number;
    @Column
    String country;
    @Column
    private String role ;
    @OneToMany(mappedBy = "sender", cascade = CascadeType.ALL)
    private List<Chat> sentMessages;

    @OneToMany(mappedBy = "receiver", cascade = CascadeType.ALL)
    private List<Chat> receivedMessages;
    @Column
    private String description;

}

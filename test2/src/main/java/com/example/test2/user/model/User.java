package com.example.test2.user.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
public class User {

    @Id //primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    private String email;
    private String role;

    private String Provider;
    private String ProviderId;
    @CreationTimestamp
    private Timestamp creatDate;


    @Builder
    public User(String username, String password, String email, String role, String provider, String providerId, Timestamp creatDate) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        Provider = provider;
        ProviderId = providerId;
        this.creatDate = creatDate;
    }
}

package com.lapitus.mysbdemo.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(schema = "sbdemo", name = "clients")
@Getter
@Setter

public class Client {

    @Id
    @GeneratedValue
    private Long pk;
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private String ipAddress;
    private String country;

    public Client() {
    }
}

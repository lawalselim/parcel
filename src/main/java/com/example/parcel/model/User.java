package com.example.parcel.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.Date;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="users")
public class User {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "{com.example.parcel.notnull.username.message}")
    @Column(name = "username")
    private String userName;

    @Column(name = "first_name")
    private String firstName;


    @Column(name = "last_name")
    private String lastName;


    @Column(name = "email",nullable = false, unique = true )
    @Email
    private String email;


    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "createDate")
    private Date userCreateDate;
    @Column(name = "notificationPermission")
    private boolean notificationPermission = true;
    @OneToMany
    private List<Address> address;


    @Size(min=6, max = 32)
    @Pattern( regexp= "\n" + "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,32}$\n") //regular expression used to provide strong password characteristics choice
    @Column(name = "password")
    @NotNull(message = "{com.example.parcel.notnull.password.message}")
    private String password;


    public User(String userName,String firstName,String lastName, String password, String email,String phoneNumber, Date userCreateDate, boolean notificationPermission) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.userCreateDate = userCreateDate;
        this.notificationPermission = notificationPermission;
    }

}

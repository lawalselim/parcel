package com.example.parcel.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
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
    private Integer id;

    @NotNull(message = "{com.example.parcel.notnull.username.message}")
    @Column(name = "userName")
    private String userName;

    @NotNull
    @Column(name = "firstName")
    private String firstName;

    @NotNull
    @Column(name = "lastName")
    private String lastName;

    @Column(name = "email" )
    @Email(message = "{com.parcel.notnull.email.message}")
    private String email;

    @NotNull
    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "createDate")
    private Date userCreateDate;

    @Column(name = "notificationPermission")
    private boolean notificationPermission = true;

    @OneToMany
    private List<Address> address;


    //@Pattern( regexp= "\n" + "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,32}$\n") //regular expression used to provide strong password characteristics choice
    @Column(name = "password")
    @NotNull(message = "{com.example.parcel.notnull.password.message}")
    private String password;


    public User(String userName,String firstName, String lastName, String password, String email, String phoneNumber, Date userCreateDate, boolean notificationPermission) {
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

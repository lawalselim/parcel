package com.example.parcel.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

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


    @Column(name = "first_name")
    private String firstName;


    @Column(name = "last_name")
    private String lastName;


    @Column(name = "email",nullable = false, unique = true )
    @Email
    private String email;


    @Column(name = "phone_number")
    private String phoneNumber;


    @OneToMany
    private List<Address> address;


    @Size(min=6, max = 32)
    @Pattern( regexp= "\n" + "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,32}$\n") //regular expression used to provide strong password characteristics choice
    @Column(name = "password")
    private String password;

    /*
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
    @ToString.Exclude
    private User user;

    @OneToMany(mappedBy = "user", cascade = {CascadeType.ALL, CascadeType.PERSIST})
    @ToString.Exclude
    private List<Cart> carts;

    @OneToMany(mappedBy = "user")
    @ToString.Exclude
    private List<Order> orders;
    /
     */

}

package com.example.parcel.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="users")
public class User {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @NotBlank
    @Column(name = "last_name")
    private String lastName;

    @NotNull
    @NotBlank
    @Column(name = "email",nullable = false, unique = true )
    @Email
    private String email;

    @NotNull
    @NotBlank
    @Column(name = "phone_number")
    private String phoneNumber;

    @NotNull
    @NotBlank
    @Column(name = "address")
    private String address;

    @NotNull
    @NotBlank
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

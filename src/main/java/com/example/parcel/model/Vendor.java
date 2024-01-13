package com.example.parcel.model;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "vendors")
public class Vendor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "fullName", nullable = false )
    private String fullName;

    @Column(name = "profilePictureUrl")
    private String profilePictureUrl;

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "vendor")
    private List <Product> product;

    public Vendor(String fullName, String profilePictureUrl, String email){
        this.fullName = fullName;
        this.profilePictureUrl = profilePictureUrl;
        this.email = email;
    }
}

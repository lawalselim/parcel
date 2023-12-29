package com.example.parcel.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="orders")
public class Order {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "orderNumber")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderNumber;
    @Column(name = "productName")
    private String productName;
    @Column(name = "productBrand")
    private String productBrand;
    @Column(name = "productDescription")
    private String productDescription;
    @Column(name = "productPrice")
    private String productPrice;
    @Column(name = "productImageUrl")
    private String productImageUrl;
    @OneToOne
    private Address address;
    @ManyToOne
    private Vendor vendor;
    @ManyToOne
    private User user;
}

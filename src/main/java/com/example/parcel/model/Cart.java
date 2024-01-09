package com.example.parcel.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cart")
public class Cart {

    @Id
    private Integer id;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "productName")
    private String productName;

    @Column(name = "productBrand")
    private String productBrand;

    @Column(name = "productDetails")
    private String productDescription;

    @Column(name = "productPrice")
    private double productPrice;

    @Column(name = "productImageUrl")
    private String productImageUrl;

    @ManyToOne
    private User user;
}
